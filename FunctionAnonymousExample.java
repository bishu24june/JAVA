package com.java8feature.example.labda;

import java.util.function.Function;

public class FunctionAnonymousExample 
{
	public static void main(String[] args)
	{
		Function<User, String> functionImpl = new FunctionImpl()
		{
			@Override
			public String apply(User user)
			{
					return user.getEmail();
			}
		};
		System.out.println(functionImpl.apply(new User()));
	}
}
