package com.java8feature.example.labda;

import java.util.function.Predicate;

class PreadicateImpl implements Predicate<User>
{

	@Override
	public boolean test(User user) 
	{
		if (user.getAge() == 41)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}

public class PredicateInterfaceExample
{

	public static void main(String[] args) 
	{
		Predicate <User>preadicateImpl = new PreadicateImpl();
		System.out.println(preadicateImpl.test(new User()));
	}

}
