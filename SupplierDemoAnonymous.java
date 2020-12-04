package com.program.java8.function;

import java.util.function.Supplier;

public class SupplierDemoAnonymous
{
    public static void main(String[] args)
    {
        Supplier<String> s = new Supplier(){
            @Override
            public String get() {
                return "Bishwa";
            }
        };
        System.out.println(s.get());
    }
}
