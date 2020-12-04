package com.program.java8.function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Java8BinaryOperator1 {

    public static void main(String[] args) {

        // BiFunction : The BinaryOperator takes two arguments of the same type and returns a result of the same type of its arguments
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;

        Integer result = func.apply(2, 3);

        System.out.println(result); // 5

        // BinaryOperator
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;

        Integer result2 = func.apply(2, 3);

        System.out.println(result2); // 5

    }

}