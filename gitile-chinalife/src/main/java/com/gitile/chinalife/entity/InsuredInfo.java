package com.gitile.chinalife.entity;


/**
 * 被保险人
 * @author Administrator
 *
 */
public class InsuredInfo {
	
	private String insuredName;//被保险人姓名
	private String insuredIdType;//证件类型
	private String insuredIdNo;//证件号码
	private String insuredGender;//被保险人性别（男:1,女:0）
	private String insuredBirthday;//被保险人生日
	private String insuredMobile;//被保险人手机
	private String insuredEmail;//被保险人邮箱
	
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredIdType() {
		return insuredIdType;
	}
	public void setInsuredIdType(String insuredIdType) {
		this.insuredIdType = insuredIdType;
	}
	public String getInsuredIdNo() {
		return insuredIdNo;
	}
	public void setInsuredIdNo(String insuredIdNo) {
		this.insuredIdNo = insuredIdNo;
	}
	public String getInsuredGender() {
		return insuredGender;
	}
	public void setInsuredGender(String insuredGender) {
		this.insuredGender = insuredGender;
	}
	public String getInsuredBirthday() {
		return insuredBirthday;
	}
	public void setInsuredBirthday(String insuredBirthday) {
		this.insuredBirthday = insuredBirthday;
	}
	public String getInsuredMobile() {
		return insuredMobile;
	}
	public void setInsuredMobile(String insuredMobile) {
		this.insuredMobile = insuredMobile;
	}
	public String getInsuredEmail() {
		return insuredEmail;
	}
	public void setInsuredEmail(String insuredEmail) {
		this.insuredEmail = insuredEmail;
	}
	
	
}
