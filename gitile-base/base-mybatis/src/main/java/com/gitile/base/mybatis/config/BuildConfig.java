package com.gitile.base.mybatis.config;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.gitile.base.mybatis.bean.Module;
import com.gitile.base.mybatis.util.DBUtils;
import com.gitile.base.mybatis.util.FileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 生成自动化代码配置文件
 */
public class BuildConfig {
	
	public void run(Connection conn, String filePath, String fileName) {
		Module module = DBUtils.tableToModule(conn);
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
			cfg.setNumberFormat("#");
			cfg.setEncoding(Locale.getDefault(), "UTF-8");
			cfg.setClassForTemplateLoading(this.getClass(),"/template");
			//得FreeMarker的关键对象———模板
			Template template = cfg.getTemplate("config.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("module", module);
			FileUtils.buildConfigFile(rootMap, filePath, fileName, template);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
