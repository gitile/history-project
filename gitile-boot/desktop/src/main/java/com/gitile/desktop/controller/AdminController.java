package com.gitile.desktop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gitile.desktop.service.AdminService;

/**
 * 管理员操作
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

   
}
