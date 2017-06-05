package com.gitile.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.gitile.api.mapper.UserInfoMapper;
import com.gitile.api.model.UserInfo;

/**
 * 基本操作
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getAll(UserInfo UserInfo) {
        if (UserInfo.getPage() != null && UserInfo.getRows() != null) {
            PageHelper.startPage(UserInfo.getPage(), UserInfo.getRows(), "id");
        }
        return userInfoMapper.selectAll();
    }

    public UserInfo getById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Long id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(UserInfo country) {
        if (country.getId() != null) {
            userInfoMapper.updateByPrimaryKey(country);
        } else {
            userInfoMapper.insert(country);
        }
    }

	public String getUsernameById(Long id) {
		return userInfoMapper.selectUsernameById(id);
	}
}
