package com.orders.rest.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.events.OrderCreatedEvent;

/**
 * Sample controller to demonstrate events.
 * 
 * @author Karthik
 *
 */
@RestController
public class EventPublishController implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	@PostMapping(path = "/event")
	public String generateEvent() {
		applicationEventPublisher.publishEvent(new OrderCreatedEvent(this,"Order Event Created"));
		return "Order Created";
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

}
