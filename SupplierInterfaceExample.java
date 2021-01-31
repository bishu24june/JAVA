package com.java8feature.example.labda;

import java.util.function.Supplier;

class SupplierImpl implements Supplier<String>
{
	@Override
	public String  get()
	{
		return "Bishwa";
	}
}

public class SupplierInterfaceExample
{

	public static void main(String[] args) 
	{
		SupplierImpl supplierImpl = new SupplierImpl();
		System.out.println(supplierImpl.get());
	}

}
