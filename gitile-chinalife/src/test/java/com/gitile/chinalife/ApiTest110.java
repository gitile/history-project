package com.gitile.chinalife;

import com.gitile.chinalife.entity.Deadline;
import com.gitile.chinalife.entity.Optional;
import com.gitile.chinalife.request.Request110;
import com.gitile.chinalife.response.Response110;

public class ApiTest110 extends BaseTest{

	public static void test110(String sessionId) throws ApiException {
		ApiClient client = getTestClient();
		Request110 request = new Request110();
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
		request.setOptional(optional);
		Deadline deadline = new Deadline();
		deadline.setBizBeginDate("2015-07-22");
		deadline.setForceBeginDate("2015-07-22");
		request.setDeadline(deadline);
		Response110 resonpse = client.execute(request, sessionId);
		System.out.println("返回code:"+resonpse.getCode());
		System.out.println("返回Msg:"+resonpse.getMsg());
		System.out.println("返回报文:"+resonpse.getBody());
		if(resonpse!=null&&Response110.CODE_100.equals(resonpse.getCode())) {
			ApiTest115.test115(resonpse.getSessionId());
		}
	}

}
