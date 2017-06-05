/*
 * 文件名称：UserSetting.java
 */
package com.gitile.desktop.model;

import javax.persistence.Table;
import javax.persistence.Column;
import com.gitile.core.bean.BaseEntity;


/**
 * 名称：
 * 模块描述：数据库表对应实体类
 * 作者：系统自动生成
 */
 @Table(name="user_setting")
public class UserSetting extends BaseEntity {

	/**构造函数**/
	public UserSetting() {}
	public UserSetting(Long id,Long userId,String theme,String background,String sildeBar,Integer panelCount,Integer defaultPanel,Integer applicationLimit,Integer arrangeType,Integer iconMarginLeft,Integer iconMarginTop) {
		this.id=id;
		this.userId=userId;
		this.theme=theme;
		this.background=background;
		this.sildeBar=sildeBar;
		this.panelCount=panelCount;
		this.defaultPanel=defaultPanel;
		this.applicationLimit=applicationLimit;
		this.arrangeType=arrangeType;
		this.iconMarginLeft=iconMarginLeft;
		this.iconMarginTop=iconMarginTop;
	}
	public UserSetting setNotNull(Long id,Long userId,String theme,String sildeBar,Integer panelCount,Integer defaultPanel,Integer applicationLimit,Integer arrangeType,Integer iconMarginLeft,Integer iconMarginTop) {
		this.id=id;
		this.userId=userId;
		this.theme=theme;
		this.sildeBar=sildeBar;
		this.panelCount=panelCount;
		this.defaultPanel=defaultPanel;
		this.applicationLimit=applicationLimit;
		this.arrangeType=arrangeType;
		this.iconMarginLeft=iconMarginLeft;
		this.iconMarginTop=iconMarginTop;
		return this;
	}
	/**属性**/
	@Column(name = "user_id")
	private Long userId;// 用户编号（非空） 
	@Column(name = "theme")
	private String theme;// 主题（非空） 
	@Column(name = "background")
	private String background;// 桌面背景图片
	@Column(name = "silde_bar")
	private String sildeBar;// 侧边栏摆放位置(left、right、top）（非空） 
	@Column(name = "panel_count")
	private Integer panelCount;// 桌面面板数量（小于10）（非空） 
	@Column(name = "default_panel")
	private Integer defaultPanel;// 默认定位面板（非空） 
	@Column(name = "application_limit")
	private Integer applicationLimit;// 应用个数限制（0表示不限制）（非空） 
	@Column(name = "arrange_type")
	private Integer arrangeType;// 图标排列类型,1竖排,2横排（非空） 
	@Column(name = "icon_margin_left")
	private Integer iconMarginLeft;// 图标左边距（非空） 
	@Column(name = "icon_margin_top")
	private Integer iconMarginTop;// 图标上边距（非空） 

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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getSildeBar() {
		return sildeBar;
	}
	public void setSildeBar(String sildeBar) {
		this.sildeBar = sildeBar;
	}
	public Integer getPanelCount() {
		return panelCount;
	}
	public void setPanelCount(Integer panelCount) {
		this.panelCount = panelCount;
	}
	public Integer getDefaultPanel() {
		return defaultPanel;
	}
	public void setDefaultPanel(Integer defaultPanel) {
		this.defaultPanel = defaultPanel;
	}
	public Integer getApplicationLimit() {
		return applicationLimit;
	}
	public void setApplicationLimit(Integer applicationLimit) {
		this.applicationLimit = applicationLimit;
	}
	public Integer getArrangeType() {
		return arrangeType;
	}
	public void setArrangeType(Integer arrangeType) {
		this.arrangeType = arrangeType;
	}
	public Integer getIconMarginLeft() {
		return iconMarginLeft;
	}
	public void setIconMarginLeft(Integer iconMarginLeft) {
		this.iconMarginLeft = iconMarginLeft;
	}
	public Integer getIconMarginTop() {
		return iconMarginTop;
	}
	public void setIconMarginTop(Integer iconMarginTop) {
		this.iconMarginTop = iconMarginTop;
	}

}