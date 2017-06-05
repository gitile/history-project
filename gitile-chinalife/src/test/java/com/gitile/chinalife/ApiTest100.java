package com.gitile.chinalife;

import com.gitile.chinalife.entity.VehicleInfo;
import com.gitile.chinalife.request.Request100;
import com.gitile.chinalife.response.Response100;

public class ApiTest100 extends BaseTest{
	
	public static void main(String[] args) throws ApiException {
//		test100();
		test200();
//		test400();
	}
	
	public static void test100() throws ApiException {
		String sessionId = String.valueOf(System.currentTimeMillis());
		ApiClient client = getTestClient();
		Request100 request = new Request100();
		VehicleInfo v = new VehicleInfo();
		v.setCityCode("330500");
		v.setLicenseNo("��E7258U");
		v.setNoLicenseFlag("0");
		request.setVehicle(v);
		Response100 resonpse = client.execute(request, sessionId);
		System.out.println("����code:"+resonpse.getCode());
		System.out.println("����Msg:"+resonpse.getMsg());
		System.out.println("���ر���:"+resonpse.getBody());
		// ��Ҫ������Ϣ
		if(resonpse!=null&&Response100.CODE_100.equals(resonpse.getCode())) {
			System.out.println(resonpse.getBody());
			ApiTest110.test110(resonpse.getSessionId());
		}
	}
	
	public static void test200() throws ApiException {
		String sessionId = String.valueOf(System.currentTimeMillis());
		ApiClient client = getTestClient();
		Request100 request = new Request100();
		VehicleInfo v = new VehicleInfo();
		v.setCityCode("330500");
		v.setLicenseNo("��E0323P");
		v.setNoLicenseFlag("0");
		request.setVehicle(v);
		Response100 resonpse = client.execute(request, sessionId);
		System.out.println("����code:"+resonpse.getCode());
		System.out.println("����Msg:"+resonpse.getMsg());
		System.out.println("���ر���:"+resonpse.getBody());
		if(resonpse!=null&&Response100.CODE_200.equals(resonpse.getCode())) {
			System.out.println(resonpse.getBody());
			ApiTest105.test105(resonpse.getSessionId());
		}
	}
	
	public static void test400() throws ApiException {
		ApiClient client = getTestClient();
		Request100 request = new Request100();
		VehicleInfo v = new VehicleInfo();
		v.setCityCode("330100");
		v.setLicenseNo("��B392A3");
		v.setNoLicenseFlag("0");
		request.setVehicle(v);
		Response100 resonpse = client.execute(request, "");
		System.out.println("����code:"+resonpse.getCode());
		System.out.println("����Msg:"+resonpse.getMsg());
		System.out.println("���ر���:"+resonpse.getBody());
	}

}
