package com.gitile.desktop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gitile.desktop.mapper.UserAccountMapper;

/**
 * 基本操作
 */
@Service
public class AdminService {

    @Autowired
    private UserAccountMapper userAccountMapper;

}
