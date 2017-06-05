package com.gitile.desktop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gitile.core.bean.AjaxResult;
import com.gitile.desktop.service.UserService;

/**
 * 页面
 */
@Controller
public class HomeController {
	
    @Autowired
    private UserService userService;
    
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request,Model model){
		return "index.ftl";
	}
	
	/**
	 * 登录页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,Model model){
		return "login.ftl";
	}
	
	/**
	 * 登录动作
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doLogin(HttpServletRequest request,Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("checkCode") String checkCode){
		AjaxResult result = new AjaxResult();
		
		return result;
	}
	
}
