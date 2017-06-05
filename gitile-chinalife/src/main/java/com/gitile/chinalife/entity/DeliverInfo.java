package com.gitile.chinalife.entity;


/**
 * 配送信息
 * @author Administrator
 *
 */
public class DeliverInfo {
	private String addresseeName;//收件人姓名
	private String addresseeMobile;//收件人手机
	private String sendDate;//配送时间
	private String invoice;//发票抬头
	private String addresseeProvince;//省份代码
	private String addresseeCity;//城市代码
	private String addresseeTown;//区县代码
	private String addresseeDetails;//收件地址
	public String getAddresseeName() {
		return addresseeName;
	}
	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}
	public String getAddresseeMobile() {
		return addresseeMobile;
	}
	public void setAddresseeMobile(String addresseeMobile) {
		this.addresseeMobile = addresseeMobile;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getAddresseeProvince() {
		return addresseeProvince;
	}
	public void setAddresseeProvince(String addresseeProvince) {
		this.addresseeProvince = addresseeProvince;
	}
	public String getAddresseeCity() {
		return addresseeCity;
	}
	public void setAddresseeCity(String addresseeCity) {
		this.addresseeCity = addresseeCity;
	}
	public String getAddresseeTown() {
		return addresseeTown;
	}
	public void setAddresseeTown(String addresseeTown) {
		this.addresseeTown = addresseeTown;
	}
	public String getAddresseeDetails() {
		return addresseeDetails;
	}
	public void setAddresseeDetails(String addresseeDetails) {
		this.addresseeDetails = addresseeDetails;
	}
	
}
