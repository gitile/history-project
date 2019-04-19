package com.gitile.chinalife;

import com.gitile.chinalife.utils.SignerUtils;

public class BaseTest {
	// ���Ի�����ַ
	public final static String TEST_API = "http://";
	// ��ʽ������ַ
	public final static String API = "http://";
	//���չ�˾��Կ
	public final static String PUBLICKEY_CHINALIFE = "";
	//������˽Կ
	public final static String PRIVATEKEY_RONGBAO = "";
	
	/**
	 * 100-115�ӿ�
	 * @return
	 */
	protected static ApiClient getTestClient() {
		return new ApiClient(API, PUBLICKEY_CHINALIFE, PRIVATEKEY_RONGBAO);
	}

	/**
	 * ����ǩ���Ƿ���ȷ
	 */
	public static void testSign() {
		String body = "<Request><InputsList><Inputs type=\"vehicleInfo\"><Input name=\"cityCode\">440300</Input><Input name=\"licenseNo\">��B54S02</Input><Input name=\"noLicenseFlag\">0</Input><Input name=\"idNo\">0206</Input><Input name=\"idNoType\">09</Input></Inputs></InputsList></Request>";
		System.out.println(body);
		System.out.println(SignerUtils.sign(body.getBytes(), SignerUtils.getPrivateKey(PRIVATEKEY_RONGBAO)));
	}
}
