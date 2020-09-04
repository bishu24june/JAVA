package com.spring.event.hadling.example;

import org.apache.log4j.Logger;

public class HelloWorld {
	private String message;
	
	private static final Logger logger = Logger.getLogger(HelloWorld.class);

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		logger.info("Your Message : " + message);
	}
}
