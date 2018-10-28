package com.orders.events;

import org.springframework.context.ApplicationEvent;


public class OrderCreatedEvent extends ApplicationEvent {

	public OrderCreatedEvent(Object source, String message) {
		super(source);
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5393756665160334616L;

}
