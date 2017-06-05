package com.gitile.chinalife;

import com.gitile.chinalife.utils.SignerUtils;

public class BaseTest {
	// ���Ի�����ַ
	public final static String TEST_API = "http://m.chinalife.com.cn/thirdOnline/thirdPartyCar/carProposalthirdPartyCarQueryInfo.do";
	// ��ʽ������ַ
	public final static String API = "http://www.chinalife.com.cn/tbcx/thirdPartyCar/carProposalthirdPartyCarQueryInfo.do";
	//���չ�˾��Կ
	public final static String PUBLICKEY_CHINALIFE = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAZFz1UL1YyjG0bMOzyuR4QC0p4BAjv26hCiXiIOJED+VgzvVyMyhM6b1OUG2+pE+BbTwnR44mcN/CdGR86/dmOefEcl1apYgV6cX8Yzt2G3UTbU5+quAa8Vk+8Ore/jL1G4oD0alsA+EPmmICRtzp98NWALZlCckrXEKLbDM5mwIDAQAB";
	//������˽Կ
	public final static String PRIVATEKEY_RONGBAO = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALFGEQ/9HrXTwJ9pwPfZW1U1LwPo5N94g7Ym9j5rAFMOTn48XZg+ei2OCzOhavA5X3uogAkBjONhLOQEDIU61SNcsmhCnRgpZNYDZHpDsh2jHWuuwBJWXF70v4v5Br0wLOLQuiiAAakg3yMyomLVoyVW+eWmDOWwaH74BecMnBitAgMBAAECgYEAp56o44VjVGo06IcGf1R2l8sB+aBtSSCa6dFNZRen5uDQN2y80wfAXvLAhMFMbHjTYAmjhuCAZz+rQq7RZ+iJPqOzxFzlFxTkqW0XbvgmbL9kS3o8EXmFYt/XbtVT8/XIuRxjRNrtT47HiIVXNtvze3uLhuJ7WSIgdbhbGfGvAcECQQDXcqK9VVTfvN+pucIGpH1/i8V6VLgfk5twRH3gcHBK3QUc/BCPKqDC6OS7W6sFKxVheahy4pYfgZHYxjhtCWZjAkEA0qQChuTL+LPu37Ya2/+Gu6hXnpvSBxlJaWdc9xBHsyglMyErlFvp6WaU3qfVJif8dsLKVCOnKDpxSGzAe7XprwJBAJj8nRUG5/rsOoJiFqXy3e7ZCISCbjB191V0PVJHZWWzpnLbhsKyyW8+Q1XLlRhZbJhH9FaIEYQT1MXyk5TRrPMCQBew4KPhWduYCTbaGX1C6Rl0Hp61MdMgkfQr7vXOu/G3gy+T/H3MNKvOoNHGGKAZATkuQWljNSq+H/2gVanUVPsCQQCNm0YH7CiGN4/u8CL5LwMvTD2fSPmN1+P7crJQhbMXwEHnom9LM9f0lDipWIwLqalgoK10USFdB5yO7+qvdWKu";
	
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
