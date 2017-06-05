package com.gitile.chinalife.request;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.ApiRuleException;
import com.gitile.chinalife.entity.ApplicantInfo;
import com.gitile.chinalife.entity.Deadline;
import com.gitile.chinalife.entity.DeliverInfo;
import com.gitile.chinalife.entity.InsuredInfo;
import com.gitile.chinalife.entity.Optional;
import com.gitile.chinalife.entity.Order;
import com.gitile.chinalife.entity.OwnerInfo;
import com.gitile.chinalife.response.Response115;
import com.gitile.chinalife.utils.StringUtils;
import com.gitile.chinalife.utils.XmlAnalyze;

/**
 * 获取报价表单接口
 *
 */
public class Request115 implements BaseRequest<Response115> {
	
	private Optional optional;// 车险保费
	private Optional force;
	private Deadline deadline;// 车险保期
	private ApplicantInfo applicantInfo;// 投保人信息
	private InsuredInfo insuredInfo;//被保险人
	private OwnerInfo ownerInfo;//车主信息
	private DeliverInfo deliverInfo;// 配送信息
	private Order order;// 订单信息

	@Override
	public Document buildRequest(Document doc) {
		// 获取根元素
		Element root = doc.getRootElement();
		// 获取根元素下级子元素Package
		Element pack = root.element("Package");
		Element request=pack.element("Request");
		Element inputsList = request.addElement("InputsList");
		if(optional!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "optional");
			inputs = XmlAnalyze.toRequestXml(inputs, optional);
		}
		if(force!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "force");
			inputs = XmlAnalyze.toRequestXml(inputs, force);
		}
		if(deadline!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "deadline");
			inputs = XmlAnalyze.toRequestXml(inputs, deadline);
		}
		if(applicantInfo!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "applicantInfo");
			inputs = XmlAnalyze.toRequestXml(inputs, applicantInfo);
		}
		if(insuredInfo!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "insuredInfo");
			inputs = XmlAnalyze.toRequestXml(inputs, insuredInfo);
		}
		if(ownerInfo!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "ownerInfo");
			inputs = XmlAnalyze.toRequestXml(inputs, ownerInfo);
		}
		if(deliverInfo!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "deliverInfo");// 这里是deliverInfo，数据字典和报文不一致
			inputs = XmlAnalyze.toRequestXml(inputs, deliverInfo);
		}
		if(order!=null) {
			Element orderEle = request.addElement("Order");
			orderEle.addElement("TBOrderId").setText(order.getOrderId());
			orderEle.addElement("Premium").setText(order.getPremium());
			Element subOrderEle = orderEle.addElement("SubOrderList");
			// 商业险
			if(order.getBizOrderId()!=null) {
				Element bizEle = subOrderEle.addElement("SubOrder").addAttribute("type", "biz");
				bizEle.addElement("TBOrderId").setText(order.getBizOrderId());
				bizEle.addElement("Premium").setText(order.getBizPremium());
				bizEle.addElement("ItemId").setText(order.getBizItemId());
			}
			// 交强险
			if(order.getForceOrderId()!=null) {
				Element forceEle = subOrderEle.addElement("SubOrder").addAttribute("type", "force");
				forceEle.addElement("TBOrderId").setText(order.getForceOrderId());
				forceEle.addElement("Premium").setText(order.getForcePremium());
				forceEle.addElement("ItemId").setText(order.getForceItemId());
			}
		}
		return doc;
	}

	@Override
	public Response115 parserResponse(String result, String publicKeyChinalife) {
		Response115 response = new Response115();
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
			// 解决返回数据状态获取不同数据
			if(StringUtils.isNotEmpty(status)) {
				if(Response115.CODE_100.equals(status)) {
					Element orderTag = pack.element("Response").element("Order");
					Element subOrderTags = orderTag.element("SubOrderList");
					for(Iterator<?> it=subOrderTags.elementIterator();it.hasNext();){
				        Element element = (Element) it.next();
				        String type = element.attributeValue("type");
				        if("biz".equals(type)) {
				        	order.setBizProposalNo(element.elementText("ProposalNo"));
				        } else if("force".equals(type)) {
				        	order.setForceProposalNo(element.elementText("ProposalNo"));
				        }
					}
				}
				response.setOrder(order);
			}
		} catch (DocumentException e) {
			response.setCode(Response115.ERROR);
			response.setBody(result);
			response.setMsg("返回结果格式不正确:"+e.getMessage());
		}
		return response;
	}

	@Override
	public void check() throws ApiRuleException {
		
	}
	
	@Override
	public Class<Response115> getResponseClass() {
		return Response115.class;
	}
	
	@Override
	public String getRequestType() {
		return "115";
	}

	public Optional getOptional() {
		return optional;
	}

	public void setOptional(Optional optional) {
		this.optional = optional;
	}

	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}

	public ApplicantInfo getApplicantInfo() {
		return applicantInfo;
	}

	public void setApplicantInfo(ApplicantInfo applicantInfo) {
		this.applicantInfo = applicantInfo;
	}

	public InsuredInfo getInsuredInfo() {
		return insuredInfo;
	}

	public void setInsuredInfo(InsuredInfo insuredInfo) {
		this.insuredInfo = insuredInfo;
	}

	public OwnerInfo getOwnerInfo() {
		return ownerInfo;
	}

	public void setOwnerInfo(OwnerInfo ownerInfo) {
		this.ownerInfo = ownerInfo;
	}

	public DeliverInfo getDeliverInfo() {
		return deliverInfo;
	}

	public void setDeliverInfo(DeliverInfo deliverInfo) {
		this.deliverInfo = deliverInfo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Optional getForce() {
		return force;
	}

	public void setForce(Optional force) {
		this.force = force;
	}

}
