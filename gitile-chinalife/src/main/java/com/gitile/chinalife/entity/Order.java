package com.gitile.chinalife.entity;

public class Order {

	private String orderId;// ��������
	private String PaymentUrl;//֧����ַ
	private String PayOrderId;// ֧��������
	private String premium;// �����ܱ���=��ҵ���ܱ���+��ǿ���ܱ���
	private String bizOrderId;//��ҵ���Ӷ�����(������)
	private String bizItemId;// ��ҵ����ƷId
	private String bizPremium;// ��ҵ���ܱ���
	private String bizProposalNo;// ��ҵ�ն�����(��ʱ)
	private String bizPolicyNo;// ��ҵ�ն�����
	
	private String forceOrderId;//��ǿ���Ӷ�����(������)
	private String forceItemId;// ��ǿ����ƷId
	private String forcePremium;// ��ǿ���ܱ���
	private String forceProposalNo;// ��ǿ�ն�����(��ʱ)
	private String forcePolicyNo;// ��ǿ�ն�����
	
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