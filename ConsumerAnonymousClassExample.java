package com.java8feature.example.labda;

import java.util.function.Consumer;


public class ConsumerAnonymousClassExample 
{

	public static void main(String[] args)
	{
		Consumer<User> consumerAnonymous = new Consumer<User>() {
			@Override
			public void accept(User user)
			{
					System.out.println(user.getEmail());
					System.out.println(user.getName());
					System.out.println(user.getAge());
					System.out.println(user.getSalary());
			}
		};
		consumerAnonymous.accept(new User());
	}

}
