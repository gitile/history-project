package com.gitile.chinalife;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.request.BaseRequest;
import com.gitile.chinalife.response.BaseResponse;
import com.gitile.chinalife.utils.DateUtils;
import com.gitile.chinalife.utils.FileUtils;
import com.gitile.chinalife.utils.SignerUtils;
import com.gitile.chinalife.utils.StringUtils;
import com.gitile.chinalife.utils.WebUtils;


/**
 * 客户端
 */
public class ApiClient {
	
	private String serverUrl;// 请求地址
	private String publicKeyChinalife;//保险公司公钥
	private String privateKeyRongBao;//第三方私钥

	private int connectTimeout = 0;
	private int readTimeout = 0;

	private Boolean needCheckRequest=true;// 是否要验证请求接口数据
	
	public ApiClient(String serverUrl, String publicKeyChinalife, String privateKeyRongBao) {
		this.serverUrl = serverUrl;
		this.publicKeyChinalife = publicKeyChinalife;
		this.privateKeyRongBao = privateKeyRongBao;
	}

	public ApiClient(String serverUrl, String publicKeyChinalife, String privateKeyRongBao, int connectTimeout, int readTimeout) {
		this(serverUrl, publicKeyChinalife, privateKeyRongBao);
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
	}

	/**
	 * 调用
	 * @param request
	 * @param session
	 * @return
	 * @throws ApiException
	 */
	public <T extends BaseResponse> T execute(BaseRequest<T> request, String session) throws ApiException {
		if(this.needCheckRequest==true){
			try{
				request.check();
			} catch(ApiRuleException e){
				T localResponse=null;
				try {
					localResponse=request.getResponseClass().newInstance();
				} catch (InstantiationException e2) {
					throw new ApiException(e2);
				} catch (IllegalAccessException e3) {
					throw new ApiException(e3);
				}
				localResponse.setCode(e.getErrCode());
				localResponse.setMsg(e.getErrMsg());
				return localResponse;
			}
		}
		Document doc = getDefaultXml(request.getRequestType(), session);
		// 获取报文体
		doc = request.buildRequest(doc);
		doc = buildSign(doc, privateKeyRongBao);
		// 编辑发送内容
		// TODO 正式上线去除
		FileUtils.saveStringToFile("D:\\request\\"+session+"\\", request.getClass().getSimpleName()+".xml", doc.asXML());
		String result = WebUtils.doPost(this.serverUrl, doc.asXML(), connectTimeout, readTimeout);
		// TODO 正式上线去除
		FileUtils.saveStringToFile("D:\\request\\"+session+"\\", request.getClass().getSimpleName()+"-response.xml", result);
		if(StringUtils.isNotEmpty(result)) {
			return request.parserResponse(result, publicKeyChinalife);
		}
		T localResponse=null;
		try {
			localResponse=request.getResponseClass().newInstance();
			localResponse.setCode("-1");
			localResponse.setMsg("车险平台接口异常，请稍后重试");
		} catch (InstantiationException e2) {
			throw new ApiException(e2);
		} catch (IllegalAccessException e3) {
			throw new ApiException(e3);
		}
		return localResponse;
	}

	public Boolean getNeedCheckRequest() {
		return needCheckRequest;
	}

	public void setNeedCheckRequest(Boolean needCheckRequest) {
		this.needCheckRequest = needCheckRequest;
	}
	
	private static Document getDefaultXml(String InsureType, String session) {
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		Element root = document.addElement("PackageList");
		Element pack = root.addElement("Package");
		Element header = pack.addElement("Header");
		header.addElement("Version").setText(ApiConstants.VERSION);
		if(!StringUtils.isEmpty(session)) {
			header.addElement("SessionId").setText(session);
		}
		header.addElement("RequestType").setText(InsureType);
		header.addElement("InsureType").setText(ApiConstants.INSURETYPE);
		header.addElement("SellerId").setText(ApiConstants.SELLERID);
		header.addElement("NeedType").setText(ApiConstants.NEEDTYPE);
		header.addElement("FlagType").setText(ApiConstants.FLAGTYPE);
		header.addElement("Status").setText("100");
		header.addElement("SendTime").setText(DateUtils.NowDatetime());
		pack.addElement("Request");
		return document;
	}
	
	private static Document buildSign(Document doc, String privateKeyRongBao) {
		Element root = doc.getRootElement();
		Element pack = root.element("Package");
		Element request=pack.element("Request");
		String requestBody = request.asXML();
		String signStr = SignerUtils.sign(requestBody.getBytes(), SignerUtils.getPrivateKey(privateKeyRongBao));
		Element sign = pack.addElement("Sign");
		sign.addCDATA(signStr);
		return doc;
	}
	
	
	/**
	 * 模拟服务端返回xml
	 * @param request
	 * @param result
	 * @return
	 * @throws ApiException
	 */
	public <T extends BaseResponse> T executeTest(BaseRequest<T> request, String resultXml) throws ApiException {
		if(StringUtils.isNotEmpty(resultXml)) {
			return request.parserResponse(resultXml, publicKeyChinalife);
		}
		return null;
	}

}
