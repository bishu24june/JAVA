package com.java8feature.example.labda;

import java.util.function.Function;

public class FunctionLambdaExample 
{
	public static void main(String[] args)
	{
		Function<User, String> functionImpl = (User user)->	user.getEmail();
		System.out.println(functionImpl.apply(new User()));
	}
}
