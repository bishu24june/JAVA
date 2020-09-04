package com.samaple.spring.annotation.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * <beans>
       <bean id = "helloWorld" class = "com.tutorialspoint.HelloWorld" />
   </beans>
 */
@Configuration
public class HelloWorldConfig {
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
