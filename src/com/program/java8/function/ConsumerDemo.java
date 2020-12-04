package com.program.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo
{

    public static void main(String[] args)
    {

        Consumer<String> print = x -> System.out.println(x);
        print.accept("java");   // java


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer = (Integer x) -> System.out.println("Out Of Loop Print = "+x);
        forEachDemo(list, consumer);

        // or call this directly
        forEachDemo(list, (Integer x) -> System.out.println("inside Of Loop Print = "+x));

        List<String> list1 = Arrays.asList("a", "ab", "abc");
        forEachDemo(list1, (String x) -> System.out.println(x.length()));

    }

    static <T> void forEachDemo(List<T> list, Consumer<T> consumer)
    {
        for (T t : list)
        {
            consumer.accept(t);
        }
    }

}
