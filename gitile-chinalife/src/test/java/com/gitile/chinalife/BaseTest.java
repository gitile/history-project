package com.gitile.chinalife;

import com.gitile.chinalife.utils.SignerUtils;

public class BaseTest {
	// 测试环境地址
	public final static String TEST_API = "http://";
	// 正式环境地址
	public final static String API = "http://";
	//保险公司公钥
	public final static String PUBLICKEY_CHINALIFE = "";
	//第三方私钥
	public final static String PRIVATEKEY_RONGBAO = "";
	
	/**
	 * 100-115接口
	 * @return
	 */
	protected static ApiClient getTestClient() {
		return new ApiClient(API, PUBLICKEY_CHINALIFE, PRIVATEKEY_RONGBAO);
	}

	/**
	 * 测试签名是否正确
	 */
	public static void testSign() {
		String body = "<Request><InputsList><Inputs type=\"vehicleInfo\"><Input name=\"cityCode\">440300</Input><Input name=\"licenseNo\">粤B54S02</Input><Input name=\"noLicenseFlag\">0</Input><Input name=\"idNo\">0206</Input><Input name=\"idNoType\">09</Input></Inputs></InputsList></Request>";
		System.out.println(body);
		System.out.println(SignerUtils.sign(body.getBytes(), SignerUtils.getPrivateKey(PRIVATEKEY_RONGBAO)));
	}
}
