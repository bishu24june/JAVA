package com.java8feature.example.labda;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

class BiFunctionImpl implements BiFunction<User,String,Boolean> 
{

	@Override
	public Boolean apply(User user,String str)
	{
			return user.getEmail().equalsIgnoreCase(str);
	}
   
}

public class BiFunctionInterfaceExample 
{

	public static void main(String[] args)
	{
		BiFunctionInterfaceExample interfaceObj = new BiFunctionInterfaceExample();
		interfaceObj.inheritance();
		interfaceObj.anonymousClass();
		interfaceObj.anonymousFunction();
	}
	
	
	public void inheritance()
	{
		BiFunction<User, String,Boolean> biFunctionImpl = new BiFunctionImpl();
		System.out.println(biFunctionImpl.apply(new User(),"bishu24june@gmail.com"));
	}
	
	public void anonymousClass()
	{
		BiFunction <User, String,Boolean> biFunctionImpl = new BiFunction<User, String,Boolean>() {

			@Override
			public Boolean apply(User user,String str) 
			{
				return user.getEmail().equalsIgnoreCase(str);
			}
    };
		System.out.println(biFunctionImpl.apply(new User(),"bishu24june@gmail.com"));
	}
	
	public void anonymousFunction()
	{
		BiFunction <User,String,Boolean> biFunctionImpl = (User user,String str)->{return (user.getEmail().equalsIgnoreCase(str));};
		//BiFunction <User,String,Boolean> biFunctionImpl = (User user,String str)->user.getEmail().equalsIgnoreCase(str);
		System.out.println(biFunctionImpl.apply(new User(),"bishu24june@gmail.com")); 
	}


}
