package com.java8feature.example.labda;

import java.util.function.Supplier;



public class SupplierAnonymousExample
{

	public static void main(String[] args) 
	{
		Supplier <String>supplierImpl = new SupplierImpl() {
			@Override
			public String  get()
			{
				return "Bishwa";
			}
		};
		System.out.println(supplierImpl.get());
	}

}
