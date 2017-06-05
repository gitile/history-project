package com.gitile.chinalife.request;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.ApiRuleException;
import com.gitile.chinalife.entity.Order;
import com.gitile.chinalife.response.Response120;
import com.gitile.chinalife.utils.StringUtils;

/**
 * ��ȡ���۱��ӿ�
 *
 */
public class Request120 implements BaseRequest<Response120> {
	
	private Order order;// ������Ϣ

	@Override
	public Document buildRequest(Document doc) {
		// ��ȡ��Ԫ��
		Element root = doc.getRootElement();
		// ��ȡ��Ԫ���¼���Ԫ��Package
		Element pack = root.element("Package");
		Element request=pack.element("Request");
		if(order!=null) {
			Element orderEle = request.addElement("Order");
			orderEle.addElement("TBOrderId").setText(order.getOrderId());
			orderEle.addElement("Premium").setText(order.getPremium());
			Element subOrderEle = orderEle.addElement("SubOrderList");
			// ��ҵ��
			if(order.getBizOrderId()!=null) {
				Element bizEle = subOrderEle.addElement("SubOrder").addAttribute("type", "biz");
				bizEle.addElement("TBOrderId").setText(order.getBizOrderId());
				bizEle.addElement("Premium").setText(order.getBizPremium());
				bizEle.addElement("ItemId").setText(order.getBizItemId());
				bizEle.addElement("ProposalNo").setText(order.getBizProposalNo());
			}
			// ��ǿ��
			if(order.getForceOrderId()!=null) {
				Element forceEle = subOrderEle.addElement("SubOrder").addAttribute("type", "force");
				forceEle.addElement("TBOrderId").setText(order.getForceOrderId());
				forceEle.addElement("Premium").setText(order.getForcePremium());
				forceEle.addElement("ItemId").setText(order.getForceItemId());
				forceEle.addElement("ProposalNo").setText(order.getForceProposalNo());
			}
		}
		return doc;
	}

	@Override
	public Response120 parserResponse(String result, String publicKeyChinalife) {
		Response120 response = new Response120();
		try {
			Document doc = DocumentHelper.parseText(result);
			response.setBody(result);
			Element root = doc.getRootElement();
			Element pack = root.element("Package");
			Element header=pack.element("Header");
			String status = header.element("Status").getText();
			response.setCode(status);
			String sessionId = header.element("SessionId").getText();
			response.setSessionId(sessionId);
			response.setMsg(header.element("ErrorMessage").getText());
			// �����������״̬��ȡ��ͬ����
			if(StringUtils.isNotEmpty(status)) {
				if(Response120.CODE_100.equals(status)) {
					Element orderTag = pack.element("Response").element("Order");
					order.setPayOrderId(orderTag.elementText("OrderId"));
					order.setPaymentUrl(orderTag.elementText("PaymentUrl"));
				}
				response.setOrder(order);
			}
		} catch (DocumentException e) {
			response.setCode(Response120.ERROR);
			response.setBody(result);
			response.setMsg("���ؽ����ʽ����ȷ:"+e.getMessage());
		}
		return response;
	}

	@Override
	public void check() throws ApiRuleException {
		if(order!=null) {
			
		} else {
			throw new ApiRuleException("-1", "������Ϣ����Ϊ��");
		}
	}
	
	@Override
	public Class<Response120> getResponseClass() {
		return Response120.class;
	}
	
	@Override
	public String getRequestType() {
		return "120";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
