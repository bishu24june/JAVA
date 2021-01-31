package com.java8feature.example.labda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;



public class SupplierLambdaExample
{
	static Supplier <String>supplierImpl = () ->	 "Nothing";	
	public static void main(String[] args) 
	{
		lamdaSupplierTest();
		//System.out.println(supplierImpl.get());
	}

	
	public static void lamdaSupplierTest()
	{
		List<String>  arrayList = new ArrayList<String>();
		//arrayList.add("Bishwa");
		//arrayList.add("Sarkar");
		System.out.println(arrayList.stream().findAny().orElseGet(supplierImpl));//Here if list is empty than print else part.
		System.out.println(arrayList.stream().findAny().orElseGet( () ->	 "NothingElse"));//Here if list is empty than print else part.
	}
}
