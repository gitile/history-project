package com.gitile.dev;

import com.gitile.boot.table.TableToBeanUtils;

/**
 * 表结构转换成实体类
 */
public class TableToBeanTest {
	
	public static void main(String[] args) {
		TableToBeanUtils.run("jdbc:mysql://localhost:3306/desktop", "root", "", "com.gitile.desktop.model");
	}

}
