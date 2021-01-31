package com.java8feature.example.labda;

import java.util.function.Function;


class FunctionImpl implements Function<User,String> 
{

	@Override
	public String apply(User user)
	{
			return user.getEmail();
	}
   
}

public class FunctionInterfaceExample 
{

	public static void main(String[] args)
	{
		Function<User, String> functionImpl = new FunctionImpl();
		System.out.println(functionImpl.apply(new User()));
	}

}
