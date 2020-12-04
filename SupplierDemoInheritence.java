package com.program.java8.function;

import java.util.function.Supplier;

public class SupplierDemoInheritence implements Supplier<String>
{
    public static void main(String[] args)
    {
        Supplier<String> s = new SupplierDemoInheritence();
        System.out.println(s.get());
    }

    @Override
    public String get() {
        return "Bishwa";
    }
}
