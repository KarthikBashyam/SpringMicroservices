package com.application.common.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@ConditionalOnProperty("application.health.enabled")
@Component
public class ApplicationHealthIndicator implements HealthIndicator, EnvironmentAware {

	private Environment environment;

	@Override
	public Health health() {
		if (environment.getProperty("spring.application.name") == null)
			return Health.down().withDetail("config", "Application name not defined").build();
		else
			return Health.up().withDetail("config", "Application name is defined").build();
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;

	}

}
