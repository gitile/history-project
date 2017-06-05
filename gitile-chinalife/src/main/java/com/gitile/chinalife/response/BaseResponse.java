package com.gitile.chinalife.response;

import java.io.Serializable;

/**
 * ������Ӧ��Ϣ��
 */
public abstract class BaseResponse implements Serializable {

	private static final long serialVersionUID = 5014379068811962022L;
	public static final String ERROR = "-1";
	
	private String code;// ����code
	private String msg;// ������Ϣ
	private String body;// ��������
	private String sessionId;//�ܹ�Ψһ��ʶһ��ҵ��Ự
	
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