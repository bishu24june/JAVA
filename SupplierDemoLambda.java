package com.program.java8.function;

import java.util.function.Supplier;

public class SupplierDemoLambda
{
    public static void main(String[] args)
    {
        Supplier<String> s = ()->"Bishwa!";
        System.out.println(s.get());
    }
}
