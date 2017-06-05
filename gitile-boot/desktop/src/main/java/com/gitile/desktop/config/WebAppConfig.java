package com.gitile.desktop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web配置
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/**
	 * 静态资源路径
	 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    /**
     * 连接器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){  
    	registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/", "/common/**", "/admin/**");
    }

}
