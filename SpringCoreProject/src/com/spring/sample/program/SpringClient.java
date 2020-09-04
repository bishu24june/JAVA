

package com.spring.sample.program;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-Module.xml","Spring-Module-anno.xml"});

		//context = new 
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.setName("Bishwa");
		obj.printHello();
		
		HelloWorld obj1 = (HelloWorld) context.getBean("helloBean");
		//obj.setName("Bishwa");
		obj1.printHello();
		
		
		CustomerService custA = (CustomerService)context.getBean("customerService");
    	custA.setMessage("Message by custA");
    	//System.out.println("Message : " + custA.getMessage());

    	//retrieve it again
    	CustomerService custB = (CustomerService)context.getBean("customerService");
    	//System.out.println("Message : " + custB.getMessage());
    	
    	/////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	//Scenario : CustomerService=prototype , CustomerAddress=singleton
    	
    	CustomerService customerServicePrototype1 = (CustomerService)context.getBean("customerServicePrototype");
    	customerServicePrototype1.getCustomerAddress().setAddress("Mumbai");
    	System.out.println("Address : " +customerServicePrototype1.getCustomerAddress().getAddress());

    	//retrieve it again
    	CustomerService customerServicePrototype2 = (CustomerService)context.getBean("customerServicePrototype");
    	System.out.println("Address : " +customerServicePrototype2.getCustomerAddress().getAddress());

    	
    	//////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	//Scenario : CustomerService=singleton , CustomerAddress=prototype
    	
    	CustomerService customerServiceSingleton = (CustomerService)context.getBean("customerServiceSingleton");
    	customerServiceSingleton.getCustomerAddress().setAddress("Mumbai");
    	System.out.println("Address : " +customerServiceSingleton.getCustomerAddress().getAddress());

    	//retrieve it again
    	CustomerService customerServicePrototype3 = (CustomerService)context.getBean("customerServiceSingleton");
    	System.out.println("Address : " +customerServicePrototype3.getCustomerAddress().getAddress());
		
		
		
	}

}
