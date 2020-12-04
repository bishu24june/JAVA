package com.java8.example.lambda;


interface StringFunction
{
    String run(String str);
}

public class LambdaWithStringFunctionDemo
{
    public static void main(String[] args)
    {
        StringFunction exclaim = (s) -> s + "!";
        StringFunction ask = (s) -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
        printFormatted1();
    }
    public static void printFormatted(String str, StringFunction format)
    {
        String result = format.run(str);
        System.out.println(result);
    }

    public static void printFormatted1()
    {
        StringFunction sf =  new StringFunction() {
            @Override
           public String run(String str)
            {
                    return str+"-";
            }
        };

        String result = sf.run("Bishwa");
       System.out.println(result);
    }
}
