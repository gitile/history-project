package com.gitile.base.core.cache.memcached;

/**
 * 统一定义Memcached中存储的各种对象的Key前缀和超时时间.
 */
public enum MemcachedObjectType {

	SSO_LOGIN_TICKKEY("sso:", 60 * 60 * 1);//单点登录令牌
	
	private String prefix;
	
	private int expiredTime;

	MemcachedObjectType(String prefix, int expiredTime) {
		this.prefix = prefix;
		this.expiredTime = expiredTime;
	}

	public String getPrefix() {
		return prefix;
	}

	public int getExpiredTime() {
		return expiredTime;
	}

}