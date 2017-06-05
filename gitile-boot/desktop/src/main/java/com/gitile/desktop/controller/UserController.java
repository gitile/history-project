package com.gitile.desktop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gitile.core.bean.AjaxResult;
import com.gitile.desktop.model.UserApplication;
import com.gitile.desktop.model.UserSetting;
import com.gitile.desktop.service.UserService;

/**
 * 普通用户操作
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * 初始化桌面设置
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/initSetting")
	public UserSetting initSetting(HttpServletRequest request,Model model){
		
		
		return null;
	}
	
    /**
     * 初始化桌面应用
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/initApplication")
	public List<UserApplication> initApplication(HttpServletRequest request,Model model){
		
		
		return null;
	}
	
	/**
     * 修改密码
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/changePassword")
	public AjaxResult changePassword(HttpServletRequest request, Model model,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword){
		AjaxResult result = new AjaxResult();
		
		return result;
	}
	
	/**
     * 添加新应用
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/addApplication")
	public AjaxResult addApplication(HttpServletRequest request, Model model,
			@RequestParam("name") String name,
			@RequestParam("panel") Integer panel,
			@RequestParam("appName") String appName,
			@RequestParam("appAvatar") String appAvatar,
			@RequestParam("windowUrl") String windowUrl,
			@RequestParam("windowStatus") String windowStatus,
			@RequestParam("windowWidth") Integer windowWidth,
			@RequestParam("windowHeight") Integer windowHeight,
			@RequestParam("sort") Integer sort){
		AjaxResult result = new AjaxResult();
		
		return result;
	}
	
	/**
     * 获取应用详细信息
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/getApplication")
	public UserApplication getApplication(HttpServletRequest request, Model model,
			@RequestParam("id") Long id){
		
		return null;
	}
	
	/**
     * 修改应用
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/updateApplication")
	public AjaxResult updateApplication(HttpServletRequest request, Model model,
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("panel") Integer panel,
			@RequestParam("appName") String appName,
			@RequestParam("appAvatar") String appAvatar,
			@RequestParam("windowUrl") String windowUrl,
			@RequestParam("windowStatus") String windowStatus,
			@RequestParam("windowWidth") Integer windowWidth,
			@RequestParam("windowHeight") Integer windowHeight,
			@RequestParam("sort") Integer sort){
		AjaxResult result = new AjaxResult();
		
		return result;
	}
	
    /**
     * 退出系统
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/common/logout")
	public AjaxResult logout(HttpServletRequest request,Model model){
		AjaxResult result = new AjaxResult();
		
		return result;
	}
   
}
