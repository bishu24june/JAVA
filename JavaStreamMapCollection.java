package com.program.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamMapCollection {

	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2, 3, 4, 5);
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());

		// square.forEach(System.out::println );

		// demonstration of forEach method
		// number.stream().map(x->x*x).forEach(y->System.out.println(y));

		// demonstration of reduce method
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		// System.out.println(even);

		// Creating list of integers
		List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

		// Finding sum of all elements
		int sum = array.stream().reduce(0, (element1, element2) -> element1 + element2);

		// Displaying sum of all elements
		System.out.println("The sum of all elements is " + sum);

		// String array
		String[] Array = { "Geeks", "for", "Geeks" };

		// The result of the reduce() method is
		// an Optional because the list on which
		// reduce() is called may be empty.
		Optional<String> String_combine = Arrays.stream(Array).reduce((str1, str2) -> str1 + "-" + str2);

		// Displaying the combined String
		if (String_combine.isPresent()) {
			System.out.println(String_combine.get());
		}
	
		
		// Creating list of integers 
        List<Integer> lintOfInt = Arrays.asList(-2, 0, 4, 6, 8); 
  
        // Finding sum of all elements 
        int sum1 = lintOfInt.stream().reduce(1, 
                (element1, element2) -> element1 + element2); 
        
       // lintOfInt.stream().reduce((element1, element2) -> element1 + element2); 
  
        // Displaying sum of all elements 
        System.out.println("The sum of all elements is " + sum1); 
        
        
      //  Stream.of(10,20,22,12,14).reduce((x,y)->x+y).ifPresent(System.out::println);

		//Stream.of(10,20,22,12,14).reduce(Integer::sum).ifPresent(System.out::println);

		//Stream.of("java", "c", "c#", "python").reduce((x,y)->y).ifPresent(System.out::println);
		//Stream.of("java", "c", "c#", "python").reduce((x,y)->x).ifPresent(System.out::println);
		//Stream.of("java", "c", "c#", "python").reduce((x,y)->x+" | "+y).ifPresent(System.out::println);
		Stream.of("java", "c", "c#", "python").reduce((x,y)->{
			System.out.println("X = "+x+"->Y = "+y);
			return "";
		});
		//Stream.of("java", "c", "c#", "python").reduce((x,y)->y+" | "+x).ifPresent(System.out::println);
		
		//String result = Stream.of("java", "c", "c#", "python").reduce("Languages:", (x,y)->x+" | "+y);
        //System.out.println(result);
        
        /*Integer arrSum = Stream.of(10,20,22,12,14).parallel().reduce(1000, (x,y)->x+y, (p,q)->{
            System.out.println("combiner called");
            return p+q;
        });
        System.out.println(arrSum);*/

	}

}
