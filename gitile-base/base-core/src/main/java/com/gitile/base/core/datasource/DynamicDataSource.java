package com.gitile.base.core.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源，实现数据库的读写分离
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override  
    protected Object determineCurrentLookupKey() {  
        return DynamicDataSourceHolder.getDataSourceType();  
    }

}
