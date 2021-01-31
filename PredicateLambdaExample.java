package com.java8feature.example.labda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;



public class PredicateLambdaExample
{
	 static Predicate <User>  preadicateImpl = user -> ( user.getAge() == 41);
	public static void main(String[] args) 
	{
		lamdaTest();
		System.out.println(preadicateImpl.test(new User()));
	}
	
	public static void lamdaTest()
	{
		List<User>  arrayList = new ArrayList<User>();
		arrayList.add(new User());
		arrayList.stream().filter(preadicateImpl).forEach(t->System.out.println(t.getAge())); //Here if filter method is true then only execute the forEach loop.
	}

}
