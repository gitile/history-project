package com.gitile.boot.table;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.gitile.boot.table.bean.Table;
import com.gitile.boot.table.bean.TableColumn;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 数据库相关操作
 *
 */
public class TableToBeanUtils {
	
	/**
	 * 生产bean实体类
	 * @param url
	 * @param username
	 * @param password
	 * @param pakcageName
	 */
	public static void run(String url, String username, String password, String pakcageName) {
		Connection conn;
		try {
			conn = getMySqlConnection(url, username, password);
			List<Table> tables = tableToModule(conn);
			for(Table t:tables) {
				tableToBean(pakcageName, t);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 表格转换成java实体类
	 * @param packageName
	 * @param table
	 */
	private static void tableToBean(String packageName, Table table) {
		String beanName = table.getBean();
		String tableComment = table.getComment();
		String modelName = ModelTemplate.dealLine(beanName, true);
		String tableName = table.getName();
		List<TableColumn> propertys = table.getColumns();
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setClassForTemplateLoading(TableToBeanUtils.class,"/template");
		//得FreeMarker的关键对象———模板
		try {
			Template template = cfg.getTemplate("model.tmp.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("modelName", modelName);
			rootMap.put("tableName", tableName);
			rootMap.put("pakageName", packageName);
			rootMap.put("modelCaption", tableComment);
			rootMap.put("improtField", ModelTemplate.buildImprotField(propertys, packageName, true));
			rootMap.put("nameField", ModelTemplate.buildNameField(propertys));
			rootMap.put("strutField", ModelTemplate.buildStrutField(propertys, modelName));
			rootMap.put("getSetField", ModelTemplate.buildGetSetField(propertys));
			String javaPath = ModelTemplate.pkgToPathMaven(packageName);
			ModelTemplate.buildTemplateFile(rootMap, javaPath + File.separator + modelName + ".java", template);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取Mysql数据库连接
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static Connection getMySqlConnection(String url, String username,
			String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	/**
	 * 将数据库表结构转换成module对象
	 * @param conn
	 * @return
	 */
	private static List<Table> tableToModule(Connection conn) {
		List<Table> tables = new ArrayList<Table>();
		try {
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			String[] tableType = { "TABLE" };
			ResultSet rs = databaseMetaData.getTables(null, null, "%", tableType);
			while (rs.next()) {
				Table table = new Table();
				String tableName = rs.getString("TABLE_NAME");
				String caption = rs.getString("REMARKS");
				table.setName(tableName);
				table.setComment(caption);
				table.setBean(ModelTemplate.dealLine(tableName, true));
				List<TableColumn> columns = buildTableColumn(databaseMetaData, tableName);
				table.setColumns(columns);
				tables.add(table);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return tables;
	}

	/**
	 * 编辑表结构属性
	 */
	private static List<TableColumn> buildTableColumn(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
		List<TableColumn> columns = new ArrayList<TableColumn>();
		ResultSet colRet = databaseMetaData.getColumns(null, "%", tableName,"%");
		while(colRet.next()) { 
			String columnName = colRet.getString("COLUMN_NAME"); 
			String columnType = colRet.getString("TYPE_NAME"); 
			int datasize = colRet.getInt("COLUMN_SIZE"); 
			int digits = colRet.getInt("DECIMAL_DIGITS"); 
			int nullable = colRet.getInt("NULLABLE");
			String caption = colRet.getString("REMARKS");
			boolean notnull = true;
			if(nullable==1) {
				notnull = false;
			}
			TableColumn column = new TableColumn();
			column.setCaption(caption);
			column.setName(columnName);
			column.setProperty(ModelTemplate.dealName(columnName.toLowerCase()));
			column.setType(columnType);
			column.setDigits(digits);
			column.setLength(datasize);
			column.setNotnull(notnull);
			columns.add(column);
		}
		return columns;
	}
	
	

}
