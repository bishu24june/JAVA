package com.java8.example.lambda;

interface Add<Integer>
{
    public Integer add(Integer intValue);
}
interface Subtract
{
    public Integer subtract(Integer intValue);
}
interface Divide
{
    public Integer divide(Integer intValue);
}
interface Multiply
{
    public Integer multiply(Integer intValue);
}

public class CalculatorLambdaDemo
{
    public  static void main(String... args)
    {
        Add<Integer> add = a -> a+2;
        Subtract subtract = a -> a-2;
        Divide divide = a -> a/2;
        Multiply multiply = a -> a*2;
        add(100,add);
        subtract(100,subtract);
        divide(100,divide);
        multiply(100,multiply);
    }

    public static void add(Integer intValue,Add<Integer> intObj)
    {
        System.out.println("Addition is = "+intObj.add(intValue));
    }
    public static void subtract(Integer intValue,Subtract intObj)
    {
        System.out.println("Subtract is = "+intObj.subtract(intValue));
    }
    public static void divide(Integer intValue,Divide intObj)
    {
        System.out.println("Divide is = "+intObj.divide(intValue));
    }
    public static void multiply(Integer intValue,Multiply intObj)
    {
        System.out.println("Multiply is = "+intObj.multiply(intValue));
    }

}
