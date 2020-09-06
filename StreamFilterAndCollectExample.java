package com.program.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterAndCollectExample {

	public static void main(String[] args) {

		function3();
		function2();
		function1();

	}

	public static void function4() {

	}

	public static void function3() {

		System.out.println("function3####################################################################");

		List<Person> persons = Arrays.asList(new Person("bishwa", 30), new Person("jack", 20),
				new Person("lawrence", 40));
		// convert stream to String
		String name = persons.stream().filter(x -> "jack".equals(x.getName())).map(Person::getName) 
				.findAny().orElse("");

		System.out.println("name : " + name);

		List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());

		collect.forEach(System.out::println);

	}

	public static void function2() {
		System.out.println("function2##################################################################");
		List<Person> persons = Arrays.asList(new Person("bishwa", 30), new Person("jack", 20),
				new Person("lawrence", 40));

		Person result1 = persons.stream() // Convert to steam
				.filter(x -> "jack".equals(x.getName())) // we want "jack" only
				.findAny() // If 'findAny' then return found
				.orElse(null); // If not found, return null

		System.out.println(result1);

		Person result2 = persons.stream().filter(x -> "ahmook".equals(x.getName())).findAny().orElse(null);

		System.out.println(result2);

	}

	public static void function1() {
		System.out.println("function1##################################################################");
		List<String> lines = Arrays.asList("spring", "node", "bishwa");

		List<String> result = lines.stream() // convert list to stream
				.filter(line -> !"bishwa".equals(line)) // we dont like bishwa
				.collect(Collectors.toList()); // collect the output and convert
												// streams to a List

		result.forEach(System.out::println); // output : spring, node

	}

}
