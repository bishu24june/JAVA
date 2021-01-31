package com.java8feature.example.labda;

import java.util.function.BiConsumer;

class BiConsumerImpl implements BiConsumer<User,String> 
{

	@Override
	public void accept(User user,String str)
	{
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			System.out.println(user.getAge());
			System.out.println(user.getSalary() + " in "+ str);
	}
   
}

public class BiConsumerInterfaceExample 
{

	public static void main(String[] args)
	{
		BiConsumerInterfaceExample interfaceObj = new BiConsumerInterfaceExample();
		interfaceObj.inheritance();
		interfaceObj.anonymousClass();
		interfaceObj.anonymousFunction();
	}
	
	public void inheritance()
	{
		BiConsumer <User,String> consumerImpl = new BiConsumerImpl();
		consumerImpl.accept(new User(),"India");
	}
	
	public void anonymousClass()
	{
		BiConsumer <User,String> consumerImpl = new BiConsumer<User,String>() {

			@Override
			public void accept(User user, String str) 
			{
				System.out.println(user.getEmail());
				System.out.println(user.getName());
				System.out.println(user.getAge());
				System.out.println(user.getSalary() + " in "+ str);
			}
			
		};
		consumerImpl.accept(new User(),"Mumbai");
	}
	
	public void anonymousFunction()
	{
		BiConsumer <User,String> consumerImpl = (User user,String str)->{
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			System.out.println(user.getAge());
			System.out.println(user.getSalary() + " in "+ str);
		};
		consumerImpl.accept(new User(),"Denmark");
	}

}
