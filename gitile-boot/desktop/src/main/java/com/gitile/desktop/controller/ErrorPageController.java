package com.gitile.desktop.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gitile.core.bean.AjaxResult;
import com.gitile.core.constants.MediaTypes;
import com.gitile.core.mapper.JsonMapper;

/**
 * 重载替换Spring Boot默认的BasicErrorController, 
 * 增加日志并让错误返回方式统一.
 */
@Controller
public class ErrorPageController implements ErrorController {

	private static Logger logger = LoggerFactory.getLogger(ErrorPageController.class);

	@Value("${error.path:/error}")
	private String errorPath;

	private JsonMapper jsonMapper = new JsonMapper();

	private ErrorAttributes errorAttributes = new DefaultErrorAttributes();

	@RequestMapping(value = "${error.path:/error}", produces = MediaTypes.JSON_UTF_8)
	public String handle(HttpServletRequest request) {
		Map<String, Object> attributes = getErrorAttributes(request);
		AjaxResult result = new AjaxResult();
		result.setCode((int)attributes.get("status"));
		result.setMessage((String) attributes.get("error"));
		logError(attributes, request);
		request.setAttribute("error", result);
		return "error.ftl";
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes, false);
	}

	private void logError(Map<String, Object> attributes, HttpServletRequest request) {
		attributes.put("from", request.getRemoteAddr());
		logger.error(jsonMapper.toJson(attributes));
	}

	@Override
	public String getErrorPath() {
		return this.errorPath;
	}
}
