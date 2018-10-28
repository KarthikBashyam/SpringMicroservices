package com.orders.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SmartApplicationListener;

import com.orders.events.OrderCreatedEvent;

@Configuration
public class OrderEventListener implements SmartApplicationListener {

	private Log log = LogFactory.getLog(OrderEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info("Order Event Created :" + event.getSource());
		System.out.println("Order Event Created :" + event.getSource());
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return OrderCreatedEvent.class.isAssignableFrom(eventType);
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return false;
	}

}
