package com.gitile.desktop.base.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;// 用户编号
	private String name;// 姓名
	private Short sex;// 性别（非空） 
	private Short status;// 用户状态(1:正常使用状态,2:帐号冻结状态,3:帐号删除状态)（非空） 
	private String deptName;// 所属部门
	private String roleName;// 所属角色
	private String positionName;// 所属部门职位
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}