package com.gitile.chinalife.utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * 车险加密/解密工具类
 */
public class SignerUtils {
	
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
	public static PrivateKey getPrivateKey(String privateKeyRongBao) {
		try {
			byte[] keyBytes = (Base64.decodeBase64(privateKeyRongBao));
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
	public static PublicKey getPublicKey(String publicKeyChinalife) {
		try {
			byte[] keyBytes = (Base64.decodeBase64(publicKeyChinalife));
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PublicKey publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}