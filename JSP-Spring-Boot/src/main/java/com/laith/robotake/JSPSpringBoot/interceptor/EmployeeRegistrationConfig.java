/*
package com.laith.robotake.JSPSpringBoot.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class EmployeeRegistrationConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(generalInterceptor()).addPathPatterns("/employee/**","/department/**");

    }
    @Bean
	public EmployeeInterceptor generalInterceptor() {
    	EmployeeInterceptor result = new EmployeeInterceptor();
		return result;
	}
}
*/
