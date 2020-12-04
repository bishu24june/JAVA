package com.program.java8.function;

public class FunctionInterfaceDemo
{
    public static void main(String[] args)
    {
        InterfaceDemo demo = () -> System.out.println("Bishwa Ranjan Sarkar");
        demo.display();
    }
}

@FunctionalInterface
interface InterfaceDemo
{
    public void display();
}
