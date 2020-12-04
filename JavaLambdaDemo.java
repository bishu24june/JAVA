package com.java8.example.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class JavaLambdaDemo
{
        public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(5);
            numbers.add(9);
            numbers.add(8);
            numbers.add(1);
            //numbers.forEach( (n) -> { System.out.println(n); } );
            //numbers.stream().forEach((Integer n)-> System.out.println(n));
            //numbers.stream().forEach((n)-> System.out.println(n));
            Consumer<Integer> consumerValue = (n)-> System.out.println(n);
            System.out.println(consumerValue);
            numbers.stream().forEach(consumerValue);
        }
}
