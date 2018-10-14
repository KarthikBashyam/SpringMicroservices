package com.application.common.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * @author Karthik
 *
 */
public class EnvironmentApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		
		event.getSpringApplication().setAdditionalProfiles("DEV");
	}
	
	

}
