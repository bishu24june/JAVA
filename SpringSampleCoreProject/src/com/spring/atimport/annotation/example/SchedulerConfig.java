package com.spring.atimport.annotation.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SchedulerConfig {

	@Scope("singleton")
	@Bean(name = "scheduler", initMethod = "init", destroyMethod = "cleanup")
	public SchedulerBo suchedulerBo() {

		return new SchedulerBo();

	}

}