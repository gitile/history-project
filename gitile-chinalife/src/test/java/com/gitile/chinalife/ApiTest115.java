package com.gitile.chinalife;

import com.gitile.chinalife.entity.ApplicantInfo;
import com.gitile.chinalife.entity.Deadline;
import com.gitile.chinalife.entity.DeliverInfo;
import com.gitile.chinalife.entity.InsuredInfo;
import com.gitile.chinalife.entity.Optional;
import com.gitile.chinalife.entity.Order;
import com.gitile.chinalife.entity.OwnerInfo;
import com.gitile.chinalife.request.Request115;
import com.gitile.chinalife.response.Response115;

public class ApiTest115 extends BaseTest{
	
	public static void main(String[] args) {
		try {
			test115("1436780462978");
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	public static void test115(String sessionId) throws ApiException {
		ApiClient client = getTestClient();
		Request115 request = new Request115();
		Optional optional = new Optional();
		optional.setCov_200("120870.0");
		optional.setCov_600("100000.0");
		optional.setCov_701("0");
		optional.setCov_702("0");
		optional.setCov_500("0");
		optional.setCov_210("0");
		optional.setCov_321("0");
		optional.setCov_231("0");
		optional.setCov_310("0");
		optional.setCov_322("0");
		optional.setCov_910("0");
		optional.setCov_911("0");
		optional.setCov_912("0");
		optional.setCov_928("0");
		optional.setCov_929("0");
		optional.setCov_921("0");
		optional.setCov_922("0");
		optional.setCov_923("0");
		optional.setBizFlag("1");
		optional.setForceFlag("1");
		optional.setBizTotalPremium("198977");
		optional.setTotalPremium("293977");
		optional.setStandardPremium("399211");
		request.setOptional(optional);
		
		Optional force = new Optional();
		force.setForcePremium("95000");
		force.setVehicleTaxPremium("0");
		force.setForceTotalPremium("95000");
		request.setForce(force);
		
		ApplicantInfo applicantInfo = new ApplicantInfo();
		applicantInfo.setApplicantName("徐富庭");
		applicantInfo.setApplicantIdType("01");
		applicantInfo.setApplicantIdNo("330522195703283000");
		applicantInfo.setApplicantMobile("15105725222");
		applicantInfo.setApplicantEmail("zhanghuang@sinosoft.com");
		request.setApplicantInfo(applicantInfo);
		
		InsuredInfo insuredInfo = new InsuredInfo();
		insuredInfo.setInsuredName("徐富庭");
		insuredInfo.setInsuredIdType("01");
		insuredInfo.setInsuredIdNo("330522195703283000");
		insuredInfo.setInsuredMobile("15105725222");
		insuredInfo.setInsuredEmail("zhanghuang@sinosoft.com");
		request.setInsuredInfo(insuredInfo);
		
		OwnerInfo ownerInfo = new OwnerInfo();
		ownerInfo.setOwnerName("徐富庭");
		ownerInfo.setOwnerIdType("01");
		ownerInfo.setOwnerIdNo("330522195703283000");
		ownerInfo.setOwnerMobile("15105725222");
		ownerInfo.setOwnerEmail("zhanghuang@sinosoft.com");
		request.setOwnerInfo(ownerInfo);
		
		DeliverInfo deliverInfo = new DeliverInfo();
		deliverInfo.setAddresseeName("徐富庭");
		deliverInfo.setAddresseeProvince("浙江");
		deliverInfo.setAddresseeCity("440300");
		deliverInfo.setAddresseeTown("西湖区");
		deliverInfo.setSendDate("1992-12-01");
		deliverInfo.setAddresseeDetails("文二路西湖国际B座");
		deliverInfo.setInvoice("淘宝（中国）软件有限公司");
		deliverInfo.setAddresseeMobile("15105725222");
		request.setDeliverInfo(deliverInfo);
		
		Deadline deadline = new Deadline();
		deadline.setBizBeginDate("2015-07-22");
		deadline.setForceBeginDate("2015-07-22");
		request.setDeadline(deadline);
		
		Order order = new Order();
		String orderNo = String.valueOf(String.valueOf(System.currentTimeMillis())+0);
		order.setOrderId(orderNo);
		order.setPremium("672107");
		order.setForceItemId(String.valueOf(System.currentTimeMillis())+1);
		order.setForceOrderId(String.valueOf(System.currentTimeMillis())+2);
		order.setForcePremium("245984");
		order.setBizOrderId(String.valueOf(System.currentTimeMillis())+3);
		order.setBizItemId(String.valueOf(System.currentTimeMillis())+4);
		order.setBizPremium("426123");
		request.setOrder(order);
		Response115 resonpse = client.execute(request, sessionId);
		System.out.println("返回code:"+resonpse.getCode());
		System.out.println("返回Msg:"+resonpse.getMsg());
		System.out.println("返回报文:"+resonpse.getBody());
	}

}
