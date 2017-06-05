package com.gitile.chinalife.request;

import org.dom4j.Document;
import com.gitile.chinalife.ApiRuleException;
import com.gitile.chinalife.response.BaseResponse;

/**
 * 基础请求接口。
 */
public interface BaseRequest<T extends BaseResponse> {

	/**
	 * 获取请求接口类型
	 */
	public String getRequestType();

	/**
	 * 编辑报文体文本内容
	 * @return
	 */
	public Document buildRequest(Document doc);
	
	/**
	 * 返回数据类型
	 * @return
	 */
	public Class<T> getResponseClass();
	
	/**
	 * 解析返回内容
	 */
	public T parserResponse(String result, String publicKeyChinalife);
	
	/**
	 * 验证参数正确性
	 */
	public void check() throws ApiRuleException;
	
}
