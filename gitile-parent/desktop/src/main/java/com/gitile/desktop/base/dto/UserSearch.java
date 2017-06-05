package com.gitile.desktop.base.dto;

import java.io.Serializable;

/**
 * 用户查询条件
 */
public class UserSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String keyword;// 关键字
	private Long deptId;// 所属部门
	private Short status;// 用户状态(1:正常使用状态,2:帐号冻结状态,3:帐号删除状态)
	private String roleId;// 所属角色
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}