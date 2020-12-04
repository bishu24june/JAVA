package com.program.java8.function;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateDemoAnonymous
{
    public static void main(String[] args)
    {
        Predicate<Integer> p = t-> {
            return 7 > t ? true : false;
        };
        System.out.println("-----"+p.test(11));
        p = t -> 7 > t;
        System.out.println(p.test(6));

    }
}
