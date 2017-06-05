package com.gitile.chinalife.response;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.ApiConstants;
import com.gitile.chinalife.entity.Order;
import com.gitile.chinalife.utils.DateUtils;
import com.gitile.chinalife.utils.StringUtils;


public class Response230 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// 承保成功
	public final static String CODE_300 = "300";// 承保失败

	private Order order;
	
	/**
	 * 解析230回调接口
	 * @param requestXml
	 * @return
	 * @throws DocumentException 
	 */
	public static Response230 parserResponse(String requestXml) throws DocumentException {
		Response230 response = new Response230();
		Document doc = DocumentHelper.parseText(requestXml);
		response.setBody(requestXml);
		Element root = doc.getRootElement();
		Element pack = root.element("Package");
		Element header=pack.element("Header");
		String status = header.element("Status").getText();
		response.setCode(status);
		String sessionId = header.element("SessionId").getText();
		response.setSessionId(sessionId);
		response.setMsg(header.element("ErrorMessage").getText());
		// 解决返回数据状态获取不同数据
		if(StringUtils.isNotEmpty(status)) {
			if(Response230.CODE_100.equals(status)) {
				Order order = new Order();
				Element orderTag = pack.element("Request").element("Order");
				order.setOrderId(orderTag.elementText("TBOrderId"));
				Element subOrderTags = orderTag.element("SubOrderList");
				for(Iterator<?> it=subOrderTags.elementIterator();it.hasNext();){
			        Element element = (Element) it.next();
			        String type = element.attributeValue("type");
			        if("biz".equals(type)) {
			        	order.setBizOrderId(element.elementText("TBOrderId"));
			        	order.setBizPolicyNo(element.elementText("PolicyNo"));
			        } else if("force".equals(type)) {
			        	order.setForceOrderId(element.elementText("TBOrderId"));
			        	order.setForcePolicyNo(element.elementText("PolicyNo"));
			        }
				}
				response.setOrder(order);
			}
			return response;
		}
		return null;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String buildResult(String resultCode) {
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		Element root = document.addElement("PackageList");
		Element pack = root.addElement("Package");
		Element header = pack.addElement("Header");
		header.addElement("Version").setText(ApiConstants.VERSION);
		if(!StringUtils.isEmpty(this.getSessionId())) {
			header.addElement("SessionId").setText(this.getSessionId());
		}
		header.addElement("RequestType").setText("230");
		header.addElement("InsureType").setText(ApiConstants.INSURETYPE);
		header.addElement("SellerId").setText(ApiConstants.SELLERID);
		header.addElement("NeedType").setText(ApiConstants.NEEDTYPE);
		header.addElement("FlagType").setText(ApiConstants.FLAGTYPE);
		header.addElement("Status").setText(resultCode);
		header.addElement("SendTime").setText(DateUtils.NowDatetime());
		return document.asXML();
	}

}
