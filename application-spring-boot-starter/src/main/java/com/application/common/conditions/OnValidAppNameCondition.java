package com.application.common.conditions;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnValidAppNameCondition extends SpringBootCondition {

	private static final String PROPERTY_NAME = "spring.application.name";

	@Override
	public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Environment environment = context.getEnvironment();

		ConditionMessage.Builder condition = ConditionMessage.forCondition("ValidAppName");

		if (environment.containsProperty(PROPERTY_NAME)) {
			String appName = environment.getProperty(PROPERTY_NAME);

			if (appName.contains("$")) {
				return ConditionOutcome.match(condition.available("Valid App Name :" + appName));
			}
		}

		return ConditionOutcome.noMatch(condition.available("Invalid App Name !! "));
	}

}
