package com.program.java8.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionDemo
{
    public static void main(String ...args)
    {
        Function<String, Integer> func = x -> x.length();

        Integer apply = func.apply("bishwa");   // 6

        System.out.println(apply);

        Function<String, Integer> func1 = x -> x.length();

        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result = func1.andThen(func2).apply("bishwa");   // 12

        System.out.println(result);

        FunctionDemo obj = new FunctionDemo();

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        // lambda
        Map<String, Integer> map = obj.convertListToMap(list, x -> x.length());

        System.out.println(map);    // {node=4, c++=3, java=4, javascript=10}

        // method reference
        Map<String, Integer> map2 = obj.convertListToMap(list, obj::getLength);

        System.out.println(map2);
    }


    public <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {

        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;

    }

    public Integer getLength(String str) {
        return str.length();
    }
}
