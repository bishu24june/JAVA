package com.java8feature.example.labda;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<User> 
{

	@Override
	public void accept(User user)
	{
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			System.out.println(user.getAge());
			System.out.println(user.getSalary());
	}
   
}

public class ConsumerInterfaceExample 
{

	public static void main(String[] args)
	{
		Consumer <User> consumerImpl = new ConsumerImpl();
		consumerImpl.accept(new User());
	}

}
