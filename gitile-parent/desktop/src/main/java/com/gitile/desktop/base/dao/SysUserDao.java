/*
 * 文件名称：SysUserDao.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao;

import java.util.List;

import com.gitile.core.bean.Page;
import com.gitile.core.mybatis.dao.BaseDao;
import com.gitile.desktop.base.dto.UserDto;

/**
 * 账号信息数据库操作
 */
public interface SysUserDao<T> extends BaseDao<T> {

	/**
	 * 根据查询条件查询用户信息条数
	 * @param page
	 * @return
	 */
	int pageCountByCondition(Page<UserDto> page);

	/**
	 * 根据查询条件查询用户信息列表
	 * @param page
	 * @return
	 */
	List<UserDto> pageListByCondition(Page<UserDto> page);
	
}