package com.application.common.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

@Configuration
public class CustomPropertySourceLocator implements PropertySourceLocator {

	@Override
	public PropertySource<?> locate(Environment environment) {
		System.out.println("==============INSIDE CUSTOM PROPERTY SOURCE LOCATOR ==================:"+environment.getProperty("spring.application.name"));
		// TODO Auto-generated method stub
		
		return null;
	}
	
	

}
