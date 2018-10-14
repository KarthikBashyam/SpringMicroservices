package com.application.common.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import com.application.common.exception.ConfigFileNotFoundException;

/**
 * 
 * @author Karthik
 * 
 *         This is a custom property source locator to read the property file
 *         based on the application name
 *
 */
@Configuration
public class CustomPropertySourceLocator implements PropertySourceLocator {

	@Override
	public PropertySource<?> locate(Environment environment) {

		String applicationName = environment.getProperty("spring.application.name");
		if (applicationName == null) {
			throw new IllegalStateException("Please define application name in your microservice.");
		}
		Properties props = new Properties();
		try {
			props.load(new FileReader(new File("C:\\Tech Buzz\\SpringConfig\\" + applicationName + ".properties")));
		} catch (FileNotFoundException e) {
			throw new ConfigFileNotFoundException(
					"Cannot find properties file in the location C:\\\\Tech Buzz\\\\SpringConfig\\\\");
		} catch (IOException e) {
			throw new ConfigFileNotFoundException(
					"Unable to read properties file from the location C:\\\\Tech Buzz\\\\SpringConfig\\\\.");
		}
		PropertiesPropertySource propertySource = new PropertiesPropertySource("props", props);

		return propertySource;
	}

}
