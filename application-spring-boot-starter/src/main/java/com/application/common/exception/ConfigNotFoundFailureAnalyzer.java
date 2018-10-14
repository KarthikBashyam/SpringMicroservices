package com.application.common.exception;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class ConfigNotFoundFailureAnalyzer extends AbstractFailureAnalyzer<ConfigFileNotFoundException> {

	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, ConfigFileNotFoundException cause) {

		return new FailureAnalysis(cause.getMessage(),
				"Please make sure config file is located in the path with application name.", cause);
	}

}
