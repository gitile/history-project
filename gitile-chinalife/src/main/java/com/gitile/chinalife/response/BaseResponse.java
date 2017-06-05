package com.gitile.chinalife.response;

import java.io.Serializable;

/**
 * 基础响应信息。
 */
public abstract class BaseResponse implements Serializable {

	private static final long serialVersionUID = 5014379068811962022L;
	public static final String ERROR = "-1";
	
	private String code;// 返回code
	private String msg;// 返回消息
	private String body;// 返回内容
	private String sessionId;//能够唯一标识一次业务会话
	
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}