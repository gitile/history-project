package com.gitile.chinalife.request;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.ApiRuleException;
import com.gitile.chinalife.entity.Deadline;
import com.gitile.chinalife.entity.InputTag;
import com.gitile.chinalife.entity.Optional;
import com.gitile.chinalife.response.Response110;
import com.gitile.chinalife.utils.StringUtils;
import com.gitile.chinalife.utils.XmlAnalyze;

/**
 * 获取报价表单接口
 *
 */
public class Request110 implements BaseRequest<Response110> {
	
	private Optional optional;// 车险保费
	private Deadline deadline;// 车险保期

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
		if(deadline!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "deadline");
			inputs = XmlAnalyze.toRequestXml(inputs, deadline);
		}
		return doc;
	}

	@Override
	public Response110 parserResponse(String result, String publicKeyChinalife) {
		Response110 response = new Response110();
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
				if(Response110.CODE_100.equals(status)) {
					Element tags = pack.element("Response").element("TagsList");
					for(Iterator<?> it=tags.elementIterator();it.hasNext();){
				        Element element = (Element) it.next();
				        String typeValue = element.attributeValue("type");
				        if("optional".equals(typeValue)) {
				        	List<InputTag> optional = XmlAnalyze.analyzeAdditionalTags(element);
				        	response.setOptional(optional);
				        } else if("force".equals(typeValue)) {
				        	List<InputTag> force = XmlAnalyze.analyzeAdditionalTags(element);
				        	response.setForce(force);
				        } else if("vehicleInfo".equals(typeValue)) {
				        	List<InputTag> vehicleInfo = XmlAnalyze.analyzeAdditionalTags(element);
				        	response.setVehicleInfo(vehicleInfo);
				        } else if("deadline".equals(typeValue)) {
				        	List<InputTag> deadline = XmlAnalyze.analyzeAdditionalTags(element);
				        	response.setDeadline(deadline);
				        }
					}
				}
			}
		} catch (DocumentException e) {
			response.setCode(Response110.ERROR);
			response.setBody(result);
			response.setMsg("返回结果格式不正确:"+e.getMessage());
		}
		return response;
	}

	@Override
	public void check() throws ApiRuleException {
		
	}
	
	@Override
	public Class<Response110> getResponseClass() {
		return Response110.class;
	}
	
	@Override
	public String getRequestType() {
		return "110";
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

}
