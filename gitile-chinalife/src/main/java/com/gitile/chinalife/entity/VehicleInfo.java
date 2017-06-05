package com.gitile.chinalife.entity;
/**
 * 车辆信息
 */
public class VehicleInfo {

	private String cityCode;// 城市代码
	private String cityName;// 城市名称
	private String licenseNo;// 车牌号
	private String noLicenseFlag;// 新车未上牌
	private String idNo;// 证件号
	private String idNoType;// 证件类型
	private String vehicleId;// 车辆Id
	private String vehicleModelName;// 车辆品牌型号
	private String vehicleCodeId;// 品牌型号Id
	private String vehicleCodeName;// 品牌型号
	private String vehicleFrameNo;// 车架号
	private String engineNo;// 发动机号
	private String firstRegisterDate;// 注册登记日期
	private String specialCarFlag;// 是否过户车
	private String specialCarDate;// 过户日期
	private String vehicleInvoiceNo;// 购车发票号
	private String vehicleInvoiceDate;// 购车发票日期
	private String runCardCertificateDate;// 行驶证发证日期
	private String vehicleSeats;// 车座数
	private String fuelType;// 燃料（能源）类型
	private String averageMile;// 年平均行驶里程
	private String forceBeginDate;// 交强险起期
	private String bizBeginDate;// 商业险起期
	private String bizQuestion;// 商业险问题
	private String bizAnswer;// 商业险问题答案
	private String forceQuestion;// 交强险问题
	private String forceAnswer;// 交强险问题答案
	
	private String ownerName;//105接口扩展
	private String ownerIdNo;//105接口扩展
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerIdNo() {
		return ownerIdNo;
	}
	public void setOwnerIdNo(String ownerIdNo) {
		this.ownerIdNo = ownerIdNo;
	}
	public String getBizQuestion() {
		return bizQuestion;
	}
	public void setBizQuestion(String bizQuestion) {
		this.bizQuestion = bizQuestion;
	}
	public String getBizAnswer() {
		return bizAnswer;
	}
	public void setBizAnswer(String bizAnswer) {
		this.bizAnswer = bizAnswer;
	}
	public String getForceQuestion() {
		return forceQuestion;
	}
	public void setForceQuestion(String forceQuestion) {
		this.forceQuestion = forceQuestion;
	}
	public String getForceAnswer() {
		return forceAnswer;
	}
	public void setForceAnswer(String forceAnswer) {
		this.forceAnswer = forceAnswer;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getNoLicenseFlag() {
		return noLicenseFlag;
	}
	public void setNoLicenseFlag(String noLicenseFlag) {
		this.noLicenseFlag = noLicenseFlag;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getIdNoType() {
		return idNoType;
	}
	public void setIdNoType(String idNoType) {
		this.idNoType = idNoType;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleModelName() {
		return vehicleModelName;
	}
	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}
	public String getVehicleCodeId() {
		return vehicleCodeId;
	}
	public void setVehicleCodeId(String vehicleCodeId) {
		this.vehicleCodeId = vehicleCodeId;
	}
	public String getVehicleCodeName() {
		return vehicleCodeName;
	}
	public void setVehicleCodeName(String vehicleCodeName) {
		this.vehicleCodeName = vehicleCodeName;
	}
	public String getVehicleFrameNo() {
		return vehicleFrameNo;
	}
	public void setVehicleFrameNo(String vehicleFrameNo) {
		this.vehicleFrameNo = vehicleFrameNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getFirstRegisterDate() {
		return firstRegisterDate;
	}
	public void setFirstRegisterDate(String firstRegisterDate) {
		this.firstRegisterDate = firstRegisterDate;
	}
	public String getSpecialCarFlag() {
		return specialCarFlag;
	}
	public void setSpecialCarFlag(String specialCarFlag) {
		this.specialCarFlag = specialCarFlag;
	}
	public String getSpecialCarDate() {
		return specialCarDate;
	}
	public void setSpecialCarDate(String specialCarDate) {
		this.specialCarDate = specialCarDate;
	}
	public String getVehicleInvoiceNo() {
		return vehicleInvoiceNo;
	}
	public void setVehicleInvoiceNo(String vehicleInvoiceNo) {
		this.vehicleInvoiceNo = vehicleInvoiceNo;
	}
	public String getVehicleInvoiceDate() {
		return vehicleInvoiceDate;
	}
	public void setVehicleInvoiceDate(String vehicleInvoiceDate) {
		this.vehicleInvoiceDate = vehicleInvoiceDate;
	}
	public String getRunCardCertificateDate() {
		return runCardCertificateDate;
	}
	public void setRunCardCertificateDate(String runCardCertificateDate) {
		this.runCardCertificateDate = runCardCertificateDate;
	}
	public String getVehicleSeats() {
		return vehicleSeats;
	}
	public void setVehicleSeats(String vehicleSeats) {
		this.vehicleSeats = vehicleSeats;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getAverageMile() {
		return averageMile;
	}
	public void setAverageMile(String averageMile) {
		this.averageMile = averageMile;
	}
	public String getForceBeginDate() {
		return forceBeginDate;
	}
	public void setForceBeginDate(String forceBeginDate) {
		this.forceBeginDate = forceBeginDate;
	}
	public String getBizBeginDate() {
		return bizBeginDate;
	}
	public void setBizBeginDate(String bizBeginDate) {
		this.bizBeginDate = bizBeginDate;
	}
	
}
