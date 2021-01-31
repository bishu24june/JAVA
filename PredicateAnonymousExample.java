package com.java8feature.example.labda;

import java.util.function.Predicate;



public class PredicateAnonymousExample
{

	public static void main(String[] args) 
	{
		Predicate <User>preadicateImpl = new PreadicateImpl() {
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
		};
		System.out.println(preadicateImpl.test(new User()));
	}

}
