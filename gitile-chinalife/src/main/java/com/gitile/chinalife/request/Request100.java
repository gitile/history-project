package com.gitile.chinalife.request;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.gitile.chinalife.ApiRuleException;
import com.gitile.chinalife.entity.InputTag;
import com.gitile.chinalife.entity.VehicleInfo;
import com.gitile.chinalife.response.Response100;
import com.gitile.chinalife.utils.StringUtils;
import com.gitile.chinalife.utils.XmlAnalyze;

/**
 * ��ȡ���۱��ӿ�
 *
 */
public class Request100 implements BaseRequest<Response100> {
	
	public VehicleInfo vehicle;

	@Override
	public Document buildRequest(Document doc) {
		// ��ȡ��Ԫ��
		Element root = doc.getRootElement();
		// ��ȡ��Ԫ���¼���Ԫ��Package
		Element pack = root.element("Package");
		Element request=pack.element("Request");
		Element inputsList = request.addElement("InputsList");
		if(vehicle!=null) {
			Element inputs = inputsList.addElement("Inputs");
			inputs.addAttribute("type", "vehicleInfo");
			inputs = XmlAnalyze.toRequestXml(inputs, vehicle);
		}
		return doc;
	}

	@Override
	public Response100 parserResponse(String result, String publicKeyChinalife) {
		Response100 response = new Response100();
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
			// ������ҵ�պͽ�ǿ�����ڷ�Χ(����Ĳ�����������ĵ�)
			response.setBizDateRange(header.element("BizDateRange").getText());
			response.setForceDateRange(header.element("ForceDateRange").getText());
			// �����������״̬��ȡ��ͬ����
			if(StringUtils.isNotEmpty(status)) {
				if(Response100.CODE_100.equals(status)||Response100.CODE_200.equals(status)) {
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
			response.setCode(Response100.ERROR);
			response.setBody(result);
			response.setMsg("���ؽ����ʽ����ȷ:"+e.getMessage());
		}
		return response;
	}

	@Override
	public void check() throws ApiRuleException {
		if(vehicle!=null) {
			if(StringUtils.isEmpty(vehicle.getCityCode())) {
				throw new ApiRuleException("-1", "���д��벻��Ϊ��");
			}
		} else {
			throw new ApiRuleException("-1", "������Ϣ����Ϊ��");
		}
	}
	
	@Override
	public Class<Response100> getResponseClass() {
		return Response100.class;
	}
	
	@Override
	public String getRequestType() {
		return "100";
	}
	
	public VehicleInfo getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleInfo vehicle) {
		this.vehicle = vehicle;
	}

}
