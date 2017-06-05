package com.gitile.chinalife;

import com.gitile.chinalife.entity.VehicleInfo;
import com.gitile.chinalife.request.Request105;
import com.gitile.chinalife.response.Response105;

public class ApiTest105 extends BaseTest{

	public static void test105(String sessionId) throws ApiException {
		ApiClient client = getTestClient();
		Request105 request105 = new Request105();
		VehicleInfo v = new VehicleInfo();
		v.setAverageMile("28000");
		request105.setVehicle(v);
		Response105 resonpse105 = client.execute(request105, sessionId);
		System.out.println("����code:"+resonpse105.getCode());
		System.out.println("����Msg:"+resonpse105.getMsg());
		System.out.println("���ر���:"+resonpse105.getBody());
		if(resonpse105!=null&&resonpse105.getCode().equals(Response105.CODE_100)) {
			ApiTest110.test110(resonpse105.getSessionId());
		}
	}

}
