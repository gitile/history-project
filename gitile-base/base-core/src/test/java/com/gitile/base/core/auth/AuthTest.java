package com.gitile.base.core.auth;

import org.junit.Assert;
import org.junit.Test;

import com.gitile.base.core.auth.AuthPassword;
import com.gitile.base.core.auth.AuthUtils;

public class AuthTest {

	@Test
    public void encodePassword() {
    	// 加密密码
		AuthPassword pass = AuthUtils.entryptPassword("123456");
		// 验证密码是否正确
		boolean result = AuthUtils.validatePassword(pass);
		Assert.assertTrue(result);
		pass.setPlainPassword("135246");
		result = AuthUtils.validatePassword(pass);
		Assert.assertFalse(result);
    }
	
}
