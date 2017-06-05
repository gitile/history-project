package com.gitile.chinalife.response;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.entity.Order;
import com.gitile.chinalife.utils.StringUtils;


public class Response215 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// 核保通过 ,允许用户付款
	public final static String CODE_101 = "101";// 修改订单金额，允许用户付款
	public final static String CODE_300 = "300";// 关闭订单

	private Order order;
	
	/**
	 * 解析215回调接口
	 * @param requestXml
	 * @return
	 * @throws DocumentException 
	 */
	public static Response215 parserResponse(String requestXml) throws DocumentException {
		Response215 response = new Response215();
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
			if(Response215.CODE_100.equals(status)) {
				Order order = new Order();
				Element orderTag = pack.element("Request").element("Order");
				order.setOrderId(orderTag.elementText("TBOrderId"));
				order.setPremium(orderTag.elementText("Premium"));
				order.setPayOrderId(orderTag.elementText("OrderId"));
				order.setPaymentUrl(orderTag.elementText("PaymentUrl"));
				Element subOrderTags = orderTag.element("SubOrderList");
				for(Iterator<?> it=subOrderTags.elementIterator();it.hasNext();){
			        Element element = (Element) it.next();
			        String type = element.attributeValue("type");
			        if("biz".equals(type)) {
			        	order.setBizOrderId(element.elementText("TBOrderId"));
			        	order.setBizProposalNo(element.elementText("ProposalNo"));
			        } else if("force".equals(type)) {
			        	order.setForceOrderId(element.elementText("TBOrderId"));
			        	order.setForceProposalNo(element.elementText("ProposalNo"));
			        }
				}
				response.setOrder(order);
			} else if(Response215.CODE_101.equals(status)) {
				// 价格改变，处理 TODO
				
				
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

}
