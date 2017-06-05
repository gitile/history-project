package com.gitile.chinalife.entity;

/**
 * 保险日期
 */
public class Deadline {

	private String bizBeginDate;// 商业险保险起期
	private String forceBeginDate;// 交强险保险起期
	
	public String getBizBeginDate() {
		return bizBeginDate;
	}
	public void setBizBeginDate(String bizBeginDate) {
		this.bizBeginDate = bizBeginDate;
	}
	public String getForceBeginDate() {
		return forceBeginDate;
	}
	public void setForceBeginDate(String forceBeginDate) {
		this.forceBeginDate = forceBeginDate;
	}
}
