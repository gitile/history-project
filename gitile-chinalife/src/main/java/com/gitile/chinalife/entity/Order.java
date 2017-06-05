package com.gitile.chinalife.entity;

public class Order {

	private String orderId;// 父订单号
	private String PaymentUrl;//支付地址
	private String PayOrderId;// 支付订单号
	private String premium;// 订单总保费=商业险总保费+交强险总保费
	private String bizOrderId;//商业险子订单号(第三方)
	private String bizItemId;// 商业险商品Id
	private String bizPremium;// 商业险总保费
	private String bizProposalNo;// 商业险订单号(临时)
	private String bizPolicyNo;// 商业险订单号
	
	private String forceOrderId;//交强险子订单号(第三方)
	private String forceItemId;// 交强险商品Id
	private String forcePremium;// 交强险总保费
	private String forceProposalNo;// 交强险订单号(临时)
	private String forcePolicyNo;// 交强险订单号
	
	public String getBizPolicyNo() {
		return bizPolicyNo;
	}
	public void setBizPolicyNo(String bizPolicyNo) {
		this.bizPolicyNo = bizPolicyNo;
	}
	public String getForcePolicyNo() {
		return forcePolicyNo;
	}
	public void setForcePolicyNo(String forcePolicyNo) {
		this.forcePolicyNo = forcePolicyNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getBizOrderId() {
		return bizOrderId;
	}
	public void setBizOrderId(String bizOrderId) {
		this.bizOrderId = bizOrderId;
	}
	public String getBizItemId() {
		return bizItemId;
	}
	public void setBizItemId(String bizItemId) {
		this.bizItemId = bizItemId;
	}
	public String getBizPremium() {
		return bizPremium;
	}
	public void setBizPremium(String bizPremium) {
		this.bizPremium = bizPremium;
	}
	public String getForceOrderId() {
		return forceOrderId;
	}
	public void setForceOrderId(String forceOrderId) {
		this.forceOrderId = forceOrderId;
	}
	public String getForceItemId() {
		return forceItemId;
	}
	public void setForceItemId(String forceItemId) {
		this.forceItemId = forceItemId;
	}
	public String getForcePremium() {
		return forcePremium;
	}
	public void setForcePremium(String forcePremium) {
		this.forcePremium = forcePremium;
	}
	public String getPaymentUrl() {
		return PaymentUrl;
	}
	public void setPaymentUrl(String paymentUrl) {
		PaymentUrl = paymentUrl;
	}
	public String getPayOrderId() {
		return PayOrderId;
	}
	public void setPayOrderId(String payOrderId) {
		PayOrderId = payOrderId;
	}
	public String getBizProposalNo() {
		return bizProposalNo;
	}
	public void setBizProposalNo(String bizProposalNo) {
		this.bizProposalNo = bizProposalNo;
	}
	public String getForceProposalNo() {
		return forceProposalNo;
	}
	public void setForceProposalNo(String forceProposalNo) {
		this.forceProposalNo = forceProposalNo;
	}

}