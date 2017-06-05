package com.gitile.chinalife.response;

import java.util.List;

import com.gitile.chinalife.entity.InputTag;

public class Response100 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// ���۳ɹ�
	public final static String CODE_200 = "200";// ��Ҫ�û���¼��Ϣ
	public final static String CODE_300 = "300";// �ܱ�
	public final static String CODE_301 = "301";// �ظ�Ͷ��
	public final static String CODE_400 = "400";// ʧ��
	
	private List<InputTag> vehicleInfo;// ����100������Ϣ/200��Ҫ���䳵����Ϣ��
	private List<InputTag> optional;// ����100ʱ����������ײ�
	private List<InputTag> force;// ����100ʱ����ǿ��
	private List<InputTag> deadline;// ����100ʱ���������ޣ���ʼ���ڣ���������ײ�ʱ����
	private String forceDateRange;//��ǿ�������ڷ�Χ
	private String bizDateRange;//��ҵ�������ڷ�Χ

	public List<InputTag> getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(List<InputTag> vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	public List<InputTag> getOptional() {
		return optional;
	}

	public void setOptional(List<InputTag> optional) {
		this.optional = optional;
	}

	public List<InputTag> getForce() {
		return force;
	}

	public void setForce(List<InputTag> force) {
		this.force = force;
	}

	public List<InputTag> getDeadline() {
		return deadline;
	}

	public void setDeadline(List<InputTag> deadline) {
		this.deadline = deadline;
	}

	public String getForceDateRange() {
		return forceDateRange;
	}

	public void setForceDateRange(String forceDateRange) {
		this.forceDateRange = forceDateRange;
	}

	public String getBizDateRange() {
		return bizDateRange;
	}

	public void setBizDateRange(String bizDateRange) {
		this.bizDateRange = bizDateRange;
	}

}
