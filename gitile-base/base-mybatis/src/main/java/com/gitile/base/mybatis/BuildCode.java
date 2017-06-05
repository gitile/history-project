package com.gitile.base.mybatis;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import com.gitile.base.mybatis.config.BuildConfig;
import com.gitile.base.mybatis.dao.BuildDao;
import com.gitile.base.mybatis.mapper.BuildMapper;
import com.gitile.base.mybatis.model.BuildModel;
import com.gitile.base.mybatis.util.DBUtils;

/**
 * 自动化代码
 *
 */
public class BuildCode {
	
	public final static String DEFAULT_CONFIG_FILE = "src/test/resources/config.xml";
	public final static String DEFAULT_CONFIG_PATH = "src/test/resources";

	/**
	 * 根据数据库生成配置文件
	 * @param url--"jdbc:mysql://localhost:3306/test"
	 * @param username--"root"
	 * @param password--"123456"
	 * @param fileName--"config.xml"
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void buildConfig(String url, String username, String password, String fileName) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtils.getMySqlConnection(url, username, password);
		BuildConfig build = new BuildConfig();
		if(StringUtils.isEmpty(fileName)) {
			fileName = "config.xml";
		}
		build.run(conn, DEFAULT_CONFIG_PATH, fileName);
	}
	
	/**
	 * 根据配置文件生成Model
	 * @param configFile--"src/test/resources/config.xml"
	 */
	public static void buildModel(String configFile) {
		BuildModel build = new BuildModel();
		build.run(configFile);
	}
	
	/**
	 * 根据配置文件生成Dao
	 * @param configFile--"src/test/resources/config.xml"
	 */
	public static void buildDao(String configFile) {
		BuildDao build = new BuildDao();
		build.run(configFile);
	}
	
	/**
	 * 根据配置文件生成Mybatis相关文件
	 * @param configFile--"src/test/resources/config.xml"
	 */
	public static void buildMybatis(String configFile) {
		BuildMapper build = new BuildMapper();
		build.run(configFile);
	}

}
