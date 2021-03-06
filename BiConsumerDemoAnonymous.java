package com.program.java8.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerDemoAnonymous
{
    public static void main(String[] args)
    {

        Map<Integer,String> mapValue = new HashMap(3);
        mapValue.put(1,"AAAA");
        mapValue.put(2,"BBBB");
        mapValue.put(3,"CCCC");

        BiConsumer <Integer,String>  biConsumer = new BiConsumer<Integer,String> ()
        {
            @Override
            public void accept(Integer t, String u) {
                System.out.println("KEy = "+t+"  Value = "+u);
            }
        };

        for (Map.Entry<Integer,String> s : mapValue.entrySet()) {
            biConsumer.accept(s.getKey(),s.getValue());
        }
    }



}
