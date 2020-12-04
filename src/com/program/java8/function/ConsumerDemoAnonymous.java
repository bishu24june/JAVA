package com.program.java8.function;

import java.util.function.Consumer;

public class ConsumerDemoAnonymous
{
    public static void main(String[] args)
    {
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c.accept("Bishwa");
    }

}
