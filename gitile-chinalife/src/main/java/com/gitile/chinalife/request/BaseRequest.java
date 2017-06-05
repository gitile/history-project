package com.gitile.chinalife.request;

import org.dom4j.Document;
import com.gitile.chinalife.ApiRuleException;
import com.gitile.chinalife.response.BaseResponse;

/**
 * ��������ӿڡ�
 */
public interface BaseRequest<T extends BaseResponse> {

	/**
	 * ��ȡ����ӿ�����
	 */
	public String getRequestType();

	/**
	 * �༭�������ı�����
	 * @return
	 */
	public Document buildRequest(Document doc);
	
	/**
	 * ������������
	 * @return
	 */
	public Class<T> getResponseClass();
	
	/**
	 * ������������
	 */
	public T parserResponse(String result, String publicKeyChinalife);
	
	/**
	 * ��֤������ȷ��
	 */
	public void check() throws ApiRuleException;
	
}
