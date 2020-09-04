package com.spring.event.hadling.example;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class SpringStartEventHandler implements ApplicationListener<ContextStartedEvent> {
	
	private static final Logger logger = Logger.getLogger(SpringStartEventHandler.class);


	public void onApplicationEvent(ContextStartedEvent event) {
		logger.info("ContextStartedEvent Received");
	}
}