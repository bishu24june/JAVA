package com.samaple.spring.annotation.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldClient1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext();

		//HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		//helloWorld.setMessage("Hello World!");
		//helloWorld.getMessage();ub

	}

}
