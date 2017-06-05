package com.gitile.desktop.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限验证拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {

	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		
		return true;
	}
	

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}