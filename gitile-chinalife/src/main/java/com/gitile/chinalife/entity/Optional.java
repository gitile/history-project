package com.gitile.chinalife.entity;

/**
 * 车险保费
 */
public class Optional {
	//套餐
	private String renewalFlag;// 是否选择续保套餐
	private String recommendFlag;// 是否选择推荐套餐
	private String luxuryFlag;// 是否选择全保套餐
	private String economicFlag;// 是否选择经济套餐
	//交强险
	private String forceFlag;// 是否选择交强险
	private String forcePremium;// 交强险保税(单位分)
	private String vehicleTaxPremium;// 车船税(单位分)
	private String forceTotalPremium;// 交强险保费(单位分)
	private String specialPromise;// 特别约定
	//商业险
	private String cov_200;// 机动车损失险
	private String cov_600;// 第三者责任险
	private String cov_701;// 司机责任险
	private String cov_702;// 乘客责任险
	private String cov_500;// 盗抢险
	private String cov_290;// 涉水险
	private String cov_231;// 玻璃险
	private String cov_210;// 划痕险
	//附加险
	private String cov_310;// 自燃损失险
	private String cov_320;// 倒车镜、车灯单独损坏险
	private String cov_321;// 指定专修厂险
	private String cov_322;// 发动机特别损失险
	// 基础不计免赔险
	private String cov_900;// 不计免赔险特约条款
	private String cov_910;// 不计免赔险(不计免赔合并)
	private String cov_911;// 不计免赔险（车损险）
	private String cov_912;// 不计免赔险（三者险）
	private String cov_921;// 不计免赔险（机动车盗抢险）
	private String cov_922;// 不计免赔险（车身划痕损失险）
	private String cov_928;// 不计免赔险（车上人员责任险（司机））
	private String cov_929;// 不计免赔险（车上人员责任险（乘客））
	private String cov_930;// 不计免赔险（车上人员责任险）
	private String cov_923;// 不计免赔险（自燃险）
	private String cov_931;// 不计免赔（附加险）
	// 是否投保商业险
	private String bizFlag;// 是否投保商业险
	// 保费明细
	private String bizTotalPremium;// 商业险保费(单位分)
	private String totalPremium;// 实际保费(单位分)
	private String standardPremium;// 应缴总保费(单位分)
	private String discountPremium;// 折扣价(单位分)
	
	public String getRenewalFlag() {
		return renewalFlag;
	}
	public void setRenewalFlag(String renewalFlag) {
		this.renewalFlag = renewalFlag;
	}
	public String getRecommendFlag() {
		return recommendFlag;
	}
	public void setRecommendFlag(String recommendFlag) {
		this.recommendFlag = recommendFlag;
	}
	public String getLuxuryFlag() {
		return luxuryFlag;
	}
	public void setLuxuryFlag(String luxuryFlag) {
		this.luxuryFlag = luxuryFlag;
	}
	public String getEconomicFlag() {
		return economicFlag;
	}
	public void setEconomicFlag(String economicFlag) {
		this.economicFlag = economicFlag;
	}
	public String getForceFlag() {
		return forceFlag;
	}
	public void setForceFlag(String forceFlag) {
		this.forceFlag = forceFlag;
	}
	public String getForcePremium() {
		return forcePremium;
	}
	public void setForcePremium(String forcePremium) {
		this.forcePremium = forcePremium;
	}
	public String getVehicleTaxPremium() {
		return vehicleTaxPremium;
	}
	public void setVehicleTaxPremium(String vehicleTaxPremium) {
		this.vehicleTaxPremium = vehicleTaxPremium;
	}
	public String getForceTotalPremium() {
		return forceTotalPremium;
	}
	public void setForceTotalPremium(String forceTotalPremium) {
		this.forceTotalPremium = forceTotalPremium;
	}
	public String getSpecialPromise() {
		return specialPromise;
	}
	public void setSpecialPromise(String specialPromise) {
		this.specialPromise = specialPromise;
	}
	public String getCov_200() {
		return cov_200;
	}
	public void setCov_200(String cov_200) {
		this.cov_200 = cov_200;
	}
	public String getCov_600() {
		return cov_600;
	}
	public void setCov_600(String cov_600) {
		this.cov_600 = cov_600;
	}
	public String getCov_701() {
		return cov_701;
	}
	public void setCov_701(String cov_701) {
		this.cov_701 = cov_701;
	}
	public String getCov_702() {
		return cov_702;
	}
	public void setCov_702(String cov_702) {
		this.cov_702 = cov_702;
	}
	public String getCov_500() {
		return cov_500;
	}
	public void setCov_500(String cov_500) {
		this.cov_500 = cov_500;
	}
	public String getCov_290() {
		return cov_290;
	}
	public void setCov_290(String cov_290) {
		this.cov_290 = cov_290;
	}
	public String getCov_231() {
		return cov_231;
	}
	public void setCov_231(String cov_231) {
		this.cov_231 = cov_231;
	}
	public String getCov_210() {
		return cov_210;
	}
	public void setCov_210(String cov_210) {
		this.cov_210 = cov_210;
	}
	public String getCov_310() {
		return cov_310;
	}
	public void setCov_310(String cov_310) {
		this.cov_310 = cov_310;
	}
	public String getCov_320() {
		return cov_320;
	}
	public void setCov_320(String cov_320) {
		this.cov_320 = cov_320;
	}
	public String getCov_321() {
		return cov_321;
	}
	public void setCov_321(String cov_321) {
		this.cov_321 = cov_321;
	}
	public String getCov_322() {
		return cov_322;
	}
	public void setCov_322(String cov_322) {
		this.cov_322 = cov_322;
	}
	public String getCov_900() {
		return cov_900;
	}
	public void setCov_900(String cov_900) {
		this.cov_900 = cov_900;
	}
	public String getCov_910() {
		return cov_910;
	}
	public void setCov_910(String cov_910) {
		this.cov_910 = cov_910;
	}
	public String getCov_911() {
		return cov_911;
	}
	public void setCov_911(String cov_911) {
		this.cov_911 = cov_911;
	}
	public String getCov_912() {
		return cov_912;
	}
	public void setCov_912(String cov_912) {
		this.cov_912 = cov_912;
	}
	public String getCov_921() {
		return cov_921;
	}
	public void setCov_921(String cov_921) {
		this.cov_921 = cov_921;
	}
	public String getCov_922() {
		return cov_922;
	}
	public void setCov_922(String cov_922) {
		this.cov_922 = cov_922;
	}
	public String getCov_928() {
		return cov_928;
	}
	public void setCov_928(String cov_928) {
		this.cov_928 = cov_928;
	}
	public String getCov_929() {
		return cov_929;
	}
	public void setCov_929(String cov_929) {
		this.cov_929 = cov_929;
	}
	public String getCov_930() {
		return cov_930;
	}
	public void setCov_930(String cov_930) {
		this.cov_930 = cov_930;
	}
	public String getCov_923() {
		return cov_923;
	}
	public void setCov_923(String cov_923) {
		this.cov_923 = cov_923;
	}
	public String getCov_931() {
		return cov_931;
	}
	public void setCov_931(String cov_931) {
		this.cov_931 = cov_931;
	}
	public String getBizFlag() {
		return bizFlag;
	}
	public void setBizFlag(String bizFlag) {
		this.bizFlag = bizFlag;
	}
	public String getBizTotalPremium() {
		return bizTotalPremium;
	}
	public void setBizTotalPremium(String bizTotalPremium) {
		this.bizTotalPremium = bizTotalPremium;
	}
	public String getTotalPremium() {
		return totalPremium;
	}
	public void setTotalPremium(String totalPremium) {
		this.totalPremium = totalPremium;
	}
	public String getStandardPremium() {
		return standardPremium;
	}
	public void setStandardPremium(String standardPremium) {
		this.standardPremium = standardPremium;
	}
	public String getDiscountPremium() {
		return discountPremium;
	}
	public void setDiscountPremium(String discountPremium) {
		this.discountPremium = discountPremium;
	}

}