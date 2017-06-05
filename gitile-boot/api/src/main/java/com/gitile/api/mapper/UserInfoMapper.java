package com.gitile.api.mapper;

import com.gitile.api.model.UserInfo;
import com.gitile.boot.utils.MyMapper;

/**
 * 用户基本操作
 */
public interface UserInfoMapper extends MyMapper<UserInfo> {
	
	public String selectUsernameById(Long id);
	
}
