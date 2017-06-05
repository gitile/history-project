package com.gitile.boot.table.bean;

import java.util.List;

/**
 * 表结构
 *
 */
public class Table {
	
	private String name;// 表名
	private String bean;// javaBean的名称
	private String comment;// 表注解
	
	private List<TableColumn> columns;// 表字段
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<TableColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}
	public String getBean() {
		return bean;
	}
	public void setBean(String bean) {
		this.bean = bean;
	}
}
