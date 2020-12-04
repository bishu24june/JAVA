package com.program.java8.function;

import java.util.function.Consumer;

public class ConsumerDemoLambda
{
    public static void main(String[] args)
    {
        Consumer<String> c = (String x)-> System.out.println(x);
        c.accept("Bishwa");
    }


}

