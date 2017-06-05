/*
 * 文件名称：UserAccount.java
 */
package com.gitile.desktop.model;

import javax.persistence.Table;
import javax.persistence.Column;
import com.gitile.core.bean.BaseEntity;

import java.util.Date;

/**
 * 名称：
 * 模块描述：数据库表对应实体类
 * 作者：系统自动生成
 */
 @Table(name="user_account")
public class UserAccount extends BaseEntity {

	/**构造函数**/
	public UserAccount() {}
	public UserAccount(Long id,String name,String username,String password,String salt,String avatar,Short admin,Short state,Date createdTime) {
		this.id=id;
		this.name=name;
		this.username=username;
		this.password=password;
		this.salt=salt;
		this.avatar=avatar;
		this.admin=admin;
		this.state=state;
		this.createdTime=createdTime;
	}
	public UserAccount setNotNull(Long id,String name,String username,String password,String salt,Short admin,Short state,Date createdTime) {
		this.id=id;
		this.name=name;
		this.username=username;
		this.password=password;
		this.salt=salt;
		this.admin=admin;
		this.state=state;
		this.createdTime=createdTime;
		return this;
	}
	/**属性**/
	@Column(name = "name")
	private String name;// 姓名（非空） 
	@Column(name = "username")
	private String username;// 用户名（非空） 
	@Column(name = "password")
	private String password;// 加密密码（非空） 
	@Column(name = "salt")
	private String salt;// 加密秘钥（非空） 
	@Column(name = "avatar")
	private String avatar;// 头像
	@Column(name = "admin")
	private Short admin;// 是否是管理员（0：不是，1：是）（非空） 
	@Column(name = "state")
	private Short state;// 账号状态(1:正常,2:锁定,3:已删除)（非空） 
	@Column(name = "created_time")
	private Date createdTime;// 账号创建时间（非空） 

	/**属性Get、Set函数**/
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Short getAdmin() {
		return admin;
	}
	public void setAdmin(Short admin) {
		this.admin = admin;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}