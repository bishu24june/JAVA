package com.program.java8.streams;

public class Employee {
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	private Integer salary;
	
	public Employee(String name,Integer salary){
		this.name = name;
		this.salary = salary;
	}

}
