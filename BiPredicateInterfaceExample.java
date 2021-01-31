package com.java8feature.example.labda;

import java.util.function.BiPredicate;

class BiPreadicateImpl implements BiPredicate<User,Integer>
{
	@Override
	public boolean test(User user,Integer length) 
	{
		if (user.getAge() == length)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}

public class BiPredicateInterfaceExample
{

	public static void main(String[] args) 
	{
		BiPredicateInterfaceExample interfaceObj = new BiPredicateInterfaceExample();
		interfaceObj.inheritance();
		interfaceObj.anonymousClass();
		interfaceObj.anonymousFunction();
	}
	
	
	
	public void inheritance()
	{
		BiPredicate <User,Integer>preadicateImpl = new BiPreadicateImpl();
		System.out.println(preadicateImpl.test(new User(),41));
	}
	
	public void anonymousClass()
	{
		BiPredicate <User,Integer> biConsumerImpl = new BiPredicate<User,Integer>() {

			@Override
			public boolean test(User user,Integer length) 
			{
				if (user.getAge() == length)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
    };
		System.out.println(biConsumerImpl.test(new User(),41));
	}
	
	public void anonymousFunction()
	{
	//	BiPredicate <User,Integer> consumerImpl = (User user,Integer length)-> {return ( user.getAge() == length);};
		BiPredicate <User,Integer> consumerImpl = (User user,Integer length)-> ( user.getAge() == length);
		System.out.println(consumerImpl.test(new User(),40)); // It will return false because age mentioned 40, It must 41.
	}

}
