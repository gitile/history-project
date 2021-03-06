package com.gitile.desktop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gitile.core.auth.AuthUtils;
import com.gitile.core.bean.Page;
import com.gitile.desktop.base.dto.SessionUser;
import com.gitile.desktop.base.dto.UserDto;
import com.gitile.desktop.base.dto.UserSearch;
import com.gitile.desktop.base.model.SysApplicationRight;
import com.gitile.desktop.base.service.UserService;

@Controller
public class SettingController {
	
	@Autowired
	private UserService userService;

	/**
	 * 获取左边菜单
	 * @param model
	 */
	private void initLeftMenu(HttpServletRequest request, Model model) {
		SessionUser sessionUser = (SessionUser)AuthUtils.getSessionUser(request);
		List<SysApplicationRight> menus = userService.findUserApplicationMenu(sessionUser.getRoleId(), 1L);
		model.addAttribute("menus", menus);
	}

	/**
	 * 账号管理
	 */
	@RequestMapping(value = "/setting/user", method = RequestMethod.GET)
	public String user(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/user.ftl";
	}
	
	/**
	 * 分页获取用户数据
	 * @param request
	 * @param model
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/setting/user_grid", method = RequestMethod.GET)
	@ResponseBody
	public Page<UserDto> user_grid(HttpServletRequest request, Model model, 
			@ModelAttribute UserSearch search,
			@RequestParam("pageNo") Integer pageNo,
			@RequestParam("pageSize") Integer pageSize) {
		Page<UserDto> page = new Page<UserDto>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setCondition(search);
		page = userService.pageUsers(page);
		return page;
	}

	
	/**
	 * 部门管理
	 */
	@RequestMapping(value = "/setting/dept", method = RequestMethod.GET)
	public String dept(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/dept.ftl";
	}

	/**
	 * 角色管理
	 */
	@RequestMapping(value = "/setting/role", method = RequestMethod.GET)
	public String role(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/role.ftl";
	}
	
	/**
	 * 应用管理
	 */
	@RequestMapping(value = "/setting/application", method = RequestMethod.GET)
	public String application(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/application.ftl";
	}
	
	/**
	 * 基础设置
	 */
	@RequestMapping(value = "/setting/base", method = RequestMethod.GET)
	public String base(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/base.ftl";
	}
	
	/**
	 * 表单设置
	 */
	@RequestMapping(value = "/setting/form", method = RequestMethod.GET)
	public String form(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/form.ftl";
	}
	
	/**
	 * 系统设置
	 */
	@RequestMapping(value = "/setting/system", method = RequestMethod.GET)
	public String system(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/system.ftl";
	}
}