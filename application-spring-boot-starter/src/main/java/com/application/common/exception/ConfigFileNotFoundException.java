package com.application.common.exception;

public class ConfigFileNotFoundException extends IllegalStateException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5929297850329303473L;

	public ConfigFileNotFoundException(String message) {
		super(message);
	}

}
