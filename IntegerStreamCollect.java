package com.program.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerStreamCollect {

	public static void main(String[] args) {
		List<Integer> listOfInteger = new ArrayList<>();
		listOfInteger.add(10);
		listOfInteger.add(90);
		listOfInteger.add(80);
		listOfInteger.add(40);
		listOfInteger.add(70);
		
		//listOfInteger = listOfInteger.stream().filter(i->i%2 == 0).collect(Collectors.toList());
		//listOfInteger = listOfInteger.stream().map(i->i+5).collect(Collectors.toList());
		List<Integer> listOfSortedValue= listOfInteger.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(listOfSortedValue);
		listOfSortedValue= listOfInteger.stream().sorted().collect(Collectors.toList());
		System.out.println(listOfSortedValue);
		//long count = listOfInteger.stream().filter(i->i>30).count();
		//System.out.println(count);
		
	}

}
