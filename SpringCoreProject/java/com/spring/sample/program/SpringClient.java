package com.spring.sample.program;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
	}

}
