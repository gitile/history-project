package com.gitile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesktopApplication {

	/**
	 * 启动嵌入式的Tomcat并初始化Spring环境.
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DesktopApplication.class, args);
	}
}
