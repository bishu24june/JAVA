package com.java8feature.example.labda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerLambdaExample 
{
	
	
	static Consumer<User> user = user->{
		System.out.println(user.getEmail());
	    System.out.println(user.getName()); 
	  //  System.out.println(user.getAge());
	    System.out.println(user.getSalary());
	};
	
	
	public static void main(String[] args)
	{
		Consumer<User> consumerAnonymous = 
		//(User user) ->
		//(user)->
				/*
		user ->
				{ 
					System.out.println(user.getEmail());
				    System.out.println(user.getName()); System.out.println(user.getAge());
				    System.out.println(user.getSalary());
			   };
				 */
		//user -> user.getAddress();
		user -> System.out.println(user.getAge());
		consumerAnonymous.accept(new User());
		lamdaTest();
	}
	
	public static void lamdaTest()
	{
		List<User>  arrayList = new ArrayList<User>();
		arrayList.add(new User());
		arrayList.stream().forEach(user);
	}
}
