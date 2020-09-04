package com.spring.atimport.annotation.example;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomerConfig {

	@Scope("prototype")
	@Bean(name = "customer", initMethod = "init", destroyMethod = "cleanup")
	public CustomerBo customerBo() {

		return new CustomerBo();

	}
}