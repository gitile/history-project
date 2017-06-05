package com.gitile.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * mybatis配置项
 */
@Component
@ConfigurationProperties(prefix = MybatisProperties.MYBATIS_PREFIX)
public class MybatisProperties {
	
    public final static String MYBATIS_PREFIX = "mybatis";

    private String model;
    private String mapper;
    private String xml;
    
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMapper() {
		return mapper;
	}
	public void setMapper(String mapper) {
		this.mapper = mapper;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}

}
