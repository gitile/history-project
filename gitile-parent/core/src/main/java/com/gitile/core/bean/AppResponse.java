package com.gitile.core.bean;

/**
 * Api操作返回信息
 */
public class AppResponse {

	public static final String ERROR = "-2";// 返回异常
	public static final String UNLOGIN = "-1";// 未登录
	public static final String FAILURE = "0";// 操作失败
	public static final String SUCCESS = "1";// 操作成功
	
	private String code;// 返回结果类型 ERROR、UNLOGIN、SUCCESS、FAILURE
	private String msg;// 返回消息
	private Object result;// 返回数据

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}