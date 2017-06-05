package com.gitile.chinalife;

import com.gitile.chinalife.entity.Order;
import com.gitile.chinalife.request.Request120;
import com.gitile.chinalife.response.Response120;

public class ApiTest120 extends BaseTest{
	
	public static void main(String[] args) throws ApiException {
		test120("cf3380cadc5145fea46095102311340e");
	}
	
	public static void test120(String sessionId) throws ApiException {
		ApiClient client = getTestClient();
		Request120 request = new Request120();
		Order order = new Order();
		order.setOrderId("136a1ffd72894050a303e27e2e2f893d");
		order.setPremium("304921");
		
		
		order.setForceOrderId("7eee4574129043a9b9887f4308ca1b24");
		order.setForceItemId("20150701002");
		order.setForcePremium("95000");
		order.setForceProposalNo("905072015330597000021");
		
		order.setBizOrderId("32c4e74a9b824f35bdae6896c6f29e42");
		order.setBizItemId("20150701001");
		order.setBizPremium("209921");
		order.setBizProposalNo("905102015330597000054");
		
		request.setOrder(order);
		Response120 resonpse = client.execute(request, sessionId);
		System.out.println("返回code:"+resonpse.getCode());
		System.out.println("返回Msg:"+resonpse.getMsg());
		System.out.println("返回报文:"+resonpse.getBody());
	}

}
