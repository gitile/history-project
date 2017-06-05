package com.gitile.chinalife.response;

import java.util.List;

import com.gitile.chinalife.entity.InputTag;

public class Response105 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// 报价成功
	public final static String CODE_200 = "200";// 需要用户补录信息
	public final static String CODE_400 = "400";// 失败
	
	private List<InputTag> vehicleInfo;// 返回100车辆信息/200需要补充车辆信息，
	private List<InputTag> optional;// 返回100时，自由组合套餐
	private List<InputTag> force;// 返回100时，交强险
	private List<InputTag> deadline;// 返回100时，保险期限（起始日期）自由组合套餐时才有
	
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

}
