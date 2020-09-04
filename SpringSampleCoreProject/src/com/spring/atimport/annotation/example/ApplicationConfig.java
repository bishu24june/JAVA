package com.spring.atimport.annotation.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 * <beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

	<import resource="config/customer.xml"/>
        <import resource="config/scheduler.xml"/>

   </beans>
 */

@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class ApplicationConfig {

}