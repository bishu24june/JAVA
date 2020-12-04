package com.program.java8.function;

import java.util.function.Consumer;

public class ConsumerDemoImplements implements Consumer<String>
{

    public static void main(String[] args)
    {
        Consumer<String> c = new ConsumerDemoImplements();
        c.accept("Bishwa");
    }

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
