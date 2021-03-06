/*
 * 文件名称：SysRoleApplicationRightDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysRoleApplicationRightDao;
import com.gitile.desktop.base.model.SysRoleApplicationRight;
import org.springframework.stereotype.Repository;

/**
 * 角色可访问权限数据库操作实现
 */
@Repository
public class SysRoleApplicationRightDaoImpl extends BaseDaoImpl<SysRoleApplicationRight> implements SysRoleApplicationRightDao<SysRoleApplicationRight> {

}