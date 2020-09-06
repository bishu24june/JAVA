package com.program.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamFlatMapExample {

	public static void main(String[] args) {

		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());

		flatStream.forEach(System.out::println);

	}

}
