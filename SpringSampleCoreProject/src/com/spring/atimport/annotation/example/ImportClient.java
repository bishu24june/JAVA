package com.spring.atimport.annotation.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportClient {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CustomerBo customer = (CustomerBo) context.getBean("customer");
		customer.printMsg("Hello 1");
		SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
		scheduler.printMsg("Hello 2");
	}
}