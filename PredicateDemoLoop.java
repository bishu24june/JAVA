package com.program.java8.function;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemoLoop
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("A","B","C","D","E","C");
        Predicate<String> s = x->x.equals("C");
        list.stream().filter(s).forEach(p->System.out.println(p));
    }
}
