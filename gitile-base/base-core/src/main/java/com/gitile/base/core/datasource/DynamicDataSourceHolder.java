package com.gitile.base.core.datasource;

/**
 * DataSource上下文句柄，通过此类设置需要访问的对应数据源
 */
public abstract class DynamicDataSourceHolder {

	public final static String MASTER_DATA_SOURCE_MYSQL = "dataSourceKeyRW";
	public final static String SLAVE_DATA_SOURCE_MYSQL = "dataSourceKeyR";
    
	/**
	 * DataSource上下文，每个线程对应相应的数据源key
	 */
	public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static Object getDataSourceType() {
		return contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}

}
