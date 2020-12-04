package com.program.java8.function;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Java8UnaryOperator1
{

    public static void main(String[] args)
    {
//functional interface; it takes an argument (object of type T) and returns an object (object of type R). The argument and output can be a different type.
        Function<Integer, Integer> func = x -> x * 2;

        Integer result = func.apply(2);

        System.out.println(result);         // 4
//The UnaryOperator takes one argument, and returns a result of the same type of its arguments.
        UnaryOperator<Integer> func2 = x -> x * 2;

        Integer result2 = func2.apply(2);

        System.out.println(result2);        // 4

    }

}