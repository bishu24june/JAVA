package com.samaple.spring.annotation.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FirstSpringClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		// ctx.register(AppConfig.class, OtherConfig.class);
		// ctx.register(AdditionalConfig.class);
		// ctx.refresh();

		// MyService myService = ctx.getBean(MyService.class);
		// myService.doStuff();
		System.out.println("Program end");
	}

}
