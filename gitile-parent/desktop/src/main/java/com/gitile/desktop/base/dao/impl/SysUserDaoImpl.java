/*
 * 文件名称：SysUserDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 14:51
 */
package com.gitile.desktop.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gitile.core.bean.Page;
import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysUserDao;
import com.gitile.desktop.base.dto.UserDto;
import com.gitile.desktop.base.model.SysUser;

/**
 * 账号信息数据库操作实现
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao<SysUser> {

	@Override
	public int pageCountByCondition(Page<UserDto> page) {
		return sqlSessionTemplate.selectOne(getSqlName("pageCountByCondition"), page);
	}

	@Override
	public List<UserDto> pageListByCondition(Page<UserDto> page) {
		return sqlSessionTemplate.selectList(getSqlName("pageListByCondition"), page);
	}

}