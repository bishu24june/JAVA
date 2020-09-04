package com.spring.event.hadling.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringEventHandlerClient {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-event-handler-app-context.xml");

		// Let us raise a start event.
		context.start();

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();

		// Let us raise a stop event.
		context.stop();
	}

}
