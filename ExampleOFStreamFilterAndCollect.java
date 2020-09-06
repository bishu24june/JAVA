package com.program.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*public class ExampleOFStreamFilterAndCollect {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "bishwa");
        List<String> result = getFilterOutput(lines, "bishwa");
        for (String temp : result) {
            System.out.println(temp);    //output : spring, node
        }

    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"bishwa".equals(line)) { // we dont like bishwa
                result.add(line);
            }
        }
        return result;
    }

}*/

class Person1 {
	
	public Person1(String name, int age){
		this.name = name;
		this.age = age;
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	int age;
	
}

public class ExampleOFStreamFilterAndCollect {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "bishwa");

        /*List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"bishwa".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println); */               //output : spring, node
		
		//System.out.println(lines.stream());
		Stream<String> names = lines.stream()
				                    .filter(name -> !"bishwa".equals(name));
		
		names.forEach(System.out::println);
		
		List<Person1> listOFPersons =  Arrays.asList(new Person1("AAA",29),new Person1("BBB",45));
					 
		Stream<Person1> person = listOFPersons.stream();
		person.forEach(System.out::println);

	}

}
