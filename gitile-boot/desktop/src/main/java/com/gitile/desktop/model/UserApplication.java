/*
 * 文件名称：UserApplication.java
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
 @Table(name="user_application")
public class UserApplication extends BaseEntity {

	/**构造函数**/
	public UserApplication() {}
	public UserApplication(Long id,Long userId,Integer panel,String appName,String appAvatar,String windowUrl,String windowStatus,Integer windowWidth,Integer windowHeight,Integer sort,Date createdTime) {
		this.id=id;
		this.userId=userId;
		this.panel=panel;
		this.appName=appName;
		this.appAvatar=appAvatar;
		this.windowUrl=windowUrl;
		this.windowStatus=windowStatus;
		this.windowWidth=windowWidth;
		this.windowHeight=windowHeight;
		this.sort=sort;
		this.createdTime=createdTime;
	}
	public UserApplication setNotNull(Long id,Long userId,Integer panel,String appName,String windowStatus,Integer windowWidth,Integer windowHeight,Integer sort,Date createdTime) {
		this.id=id;
		this.userId=userId;
		this.panel=panel;
		this.appName=appName;
		this.windowStatus=windowStatus;
		this.windowWidth=windowWidth;
		this.windowHeight=windowHeight;
		this.sort=sort;
		this.createdTime=createdTime;
		return this;
	}
	/**属性**/
	@Column(name = "user_id")
	private Long userId;// （非空） 
	@Column(name = "panel")
	private Integer panel;// 所属桌面(10以内,0表示侧边栏)（非空） 
	@Column(name = "app_name")
	private String appName;// 应用名称（非空） 
	@Column(name = "app_avatar")
	private String appAvatar;// 应用图标
	@Column(name = "window_url")
	private String windowUrl;// 访问url
	@Column(name = "window_status")
	private String windowStatus;// 打开窗口时显示状态('regular', 'maximized', 'minimized' )（非空） 
	@Column(name = "window_width")
	private Integer windowWidth;// 窗口宽度（非空） 
	@Column(name = "window_height")
	private Integer windowHeight;// 窗口高度（非空） 
	@Column(name = "sort")
	private Integer sort;// 应用排序（非空） 
	@Column(name = "created_time")
	private Date createdTime;// 安装日期（非空） 

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getPanel() {
		return panel;
	}
	public void setPanel(Integer panel) {
		this.panel = panel;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppAvatar() {
		return appAvatar;
	}
	public void setAppAvatar(String appAvatar) {
		this.appAvatar = appAvatar;
	}
	public String getWindowUrl() {
		return windowUrl;
	}
	public void setWindowUrl(String windowUrl) {
		this.windowUrl = windowUrl;
	}
	public String getWindowStatus() {
		return windowStatus;
	}
	public void setWindowStatus(String windowStatus) {
		this.windowStatus = windowStatus;
	}
	public Integer getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(Integer windowWidth) {
		this.windowWidth = windowWidth;
	}
	public Integer getWindowHeight() {
		return windowHeight;
	}
	public void setWindowHeight(Integer windowHeight) {
		this.windowHeight = windowHeight;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}