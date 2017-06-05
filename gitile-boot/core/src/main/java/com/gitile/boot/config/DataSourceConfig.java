package com.gitile.boot.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Druid数据源配置
 */
@Configuration
public class DataSourceConfig {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public ServletRegistrationBean druidServlet() {
        LOGGER.debug("Registered druid servlet");
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        LOGGER.debug("Registered druid filter");
        return filterRegistrationBean;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource druidDataSource(
    		@Value("${spring.datasource.driver-class-name}") String driver,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.initialSize}") Integer initialSize,
            @Value("${spring.datasource.maxActive}") Integer maxActive,
            @Value("${spring.datasource.minIdle}") Integer minIdle,
            @Value("${spring.datasource.validationQuery}") String validationQuery) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setValidationQuery(validationQuery);
        try {
            LOGGER.debug("Setting 'application.properties' into druid");
            druidDataSource.setFilters("stat, wall");
        } catch (SQLException e) {
            throw new IllegalStateException("Could not initial Druid DataSource\n" + e);
        }
        return druidDataSource;
    }

}
