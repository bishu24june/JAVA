package com.samaple.spring.annotation.example;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldClient {
	
	private static final Logger logger = Logger.getLogger(HelloWorldConfig.class);
	

	private static ApplicationContext ctx;
	private static  AnnotationConfigApplicationContext annotCTX; 

	public static void main(String[] args) {
		logger.info("----------------Program Started---------------");
		ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		   /*HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		   helloWorld.setMessage("Hello World!");
		   helloWorld.getMessage();*/
		   
		   
		   //you can load various configuration classes as follows
		   
		   annotCTX = new AnnotationConfigApplicationContext();

		   //annotCTX.register(HelloWorldConfig.class, HelloWorldConfig.class);
		   annotCTX.register(HelloWorldConfig.class);
		   annotCTX.refresh();

		   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		   helloWorld.setMessage("Hello World!");
		   helloWorld.getMessage(); 
		   logger.info("----------------Program Ended---------------");
		   
		}
		   
	
}
