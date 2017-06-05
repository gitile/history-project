package com.gitile.chinalife.entity;

/**
 * 返回需要输入的信息
 *
 */
public class InputTag {
	
	private String type;// 控件类型
	private String key;// 控件名称
	private String label;// 控件显示名
	private String value;// 控件默认值
	private String premium;// 控件保费(套餐中的控件才需要这个值，单位：分)
	private String disable;// 控件是否可编辑(0可编辑，1不可编辑)
	private String dataUrl;// 控件初始化Url地址（暂时未开放）
	private String data;// 控件的初始化数据配置(结构如key1:value1;key2:value2，一般常用于下拉控件)
	private String check;// 控件参数校验规则(一般为正则表达式（暂时未开放）)
	private String checkUrl;// 控件参数校验请求地址(同dataUrl一样，当控件参数中的值同保险公司具体的业务场景相关时，就必须实时流程中请求保险公司判断参数格式。（暂时未开放）)
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getDisable() {
		return disable;
	}
	public void setDisable(String disable) {
		this.disable = disable;
	}
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getCheckUrl() {
		return checkUrl;
	}
	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
