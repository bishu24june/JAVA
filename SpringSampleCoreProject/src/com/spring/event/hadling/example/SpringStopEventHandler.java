package com.spring.event.hadling.example;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class SpringStopEventHandler implements ApplicationListener<ContextStoppedEvent> {

	private static final Logger logger = Logger.getLogger(SpringStopEventHandler.class);

	public void onApplicationEvent(ContextStoppedEvent event) {
		logger.info("ContextStoppedEvent Received");

	}
}