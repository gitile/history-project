package com.gitile.desktop;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author zhanghuang@sinosoft.com.cn
 * 
 */
public class DefaultThirdSigner {
	
	private static final String ALGORITHM = "RSA";
	private static final String SIGNPARAMTER = "MD5WithRSA";
   //加密
	public static String sign(byte[] data, PrivateKey priKey) {
		try {
			Signature signature = Signature.getInstance(SIGNPARAMTER);
			signature.initSign(priKey);
			signature.update(data);
			return Base64.encodeBase64URLSafeString(signature.sign());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    //解密
	public static boolean verify(byte[] data, String sign, PublicKey pubKey) {
		try {
			Signature signature = Signature.getInstance(SIGNPARAMTER);
			signature.initVerify(pubKey);
			String source = new String(data);
			int pos = source.indexOf("?");
			if(pos ==0){
				source = source.replaceFirst("\\?", "");
			}
			signature.update(source.getBytes());
			return signature.verify(Base64.decodeBase64(sign));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//加密
	public static PrivateKey getPrivateKey() {
		try {
			byte[] keyBytes = (Base64.decodeBase64(privateKey_RongBao));
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
			return privateKey;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//解密
	public static PublicKey getPublicKey() {
		try {
			byte[] keyBytes = (Base64.decodeBase64(publicKey_Chinalife));
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PublicKey publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	//生成秘钥对
	private byte[] pubKey;
	private byte[] priKey;

	public byte[] getPubKey() {
		return pubKey;
	}
	public void setPubKey(byte[] pubKey) {
		this.pubKey = pubKey;
	}
	public byte[] getPriKey() {
		return priKey;
	}
	public void setPriKey(byte[] priKey) {
		this.priKey = priKey;
	}
	//保险公司公钥
	static String publicKey_Chinalife = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAZFz1UL1YyjG0bMOzyuR4QC0p4BAjv26hCiXiIOJED+VgzvVyMyhM6b1OUG2+pE+BbTwnR44mcN/CdGR86/dmOefEcl1apYgV6cX8Yzt2G3UTbU5+quAa8Vk+8Ore/jL1G4oD0alsA+EPmmICRtzp98NWALZlCckrXEKLbDM5mwIDAQAB";
	//第三方私钥
	static String privateKey_RongBao = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALFGEQ/9HrXTwJ9pwPfZW1U1LwPo5N94g7Ym9j5rAFMOTn48XZg+ei2OCzOhavA5X3uogAkBjONhLOQEDIU61SNcsmhCnRgpZNYDZHpDsh2jHWuuwBJWXF70v4v5Br0wLOLQuiiAAakg3yMyomLVoyVW+eWmDOWwaH74BecMnBitAgMBAAECgYEAp56o44VjVGo06IcGf1R2l8sB+aBtSSCa6dFNZRen5uDQN2y80wfAXvLAhMFMbHjTYAmjhuCAZz+rQq7RZ+iJPqOzxFzlFxTkqW0XbvgmbL9kS3o8EXmFYt/XbtVT8/XIuRxjRNrtT47HiIVXNtvze3uLhuJ7WSIgdbhbGfGvAcECQQDXcqK9VVTfvN+pucIGpH1/i8V6VLgfk5twRH3gcHBK3QUc/BCPKqDC6OS7W6sFKxVheahy4pYfgZHYxjhtCWZjAkEA0qQChuTL+LPu37Ya2/+Gu6hXnpvSBxlJaWdc9xBHsyglMyErlFvp6WaU3qfVJif8dsLKVCOnKDpxSGzAe7XprwJBAJj8nRUG5/rsOoJiFqXy3e7ZCISCbjB191V0PVJHZWWzpnLbhsKyyW8+Q1XLlRhZbJhH9FaIEYQT1MXyk5TRrPMCQBew4KPhWduYCTbaGX1C6Rl0Hp61MdMgkfQr7vXOu/G3gy+T/H3MNKvOoNHGGKAZATkuQWljNSq+H/2gVanUVPsCQQCNm0YH7CiGN4/u8CL5LwMvTD2fSPmN1+P7crJQhbMXwEHnom9LM9f0lDipWIwLqalgoK10USFdB5yO7+qvdWKu";

}