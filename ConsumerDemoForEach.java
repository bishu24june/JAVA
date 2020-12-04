package com.program.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemoForEach
{
    public static void main(String[] args)
    {
        Consumer<String> c = (String x)-> System.out.print(" "+x);
        c.accept("Bishwa");
        List<String> list = Arrays.asList("A","B","C","D","E");

        list.forEach(c);
        System.out.println();
        list.stream().forEach(c);
        System.out.println();
        list.parallelStream().forEach(c);//ParallelStream print value random order
        System.out.println();
        list.forEach((String x)-> System.out.print(x));
        System.out.println();
        c.accept("Sarkar");
    }

}
