package com.java8feature.example.labda;

import java.util.Arrays;
import java.util.List;

public class User 
{
	   private String name="Bishwa";
	   private Integer age=41;
	   private Integer salary=12345;
	   private String email="bishu24june@gmail.com";
	   private Integer zip=400701;
	   private List<String> address = Arrays.asList("Bhilai","Pune","Mumbai","Navi Mumbai");
	   private List<String> country = Arrays.asList("Inida","SA","Norway","Sweden");
	   
	   
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public List<String> getCountry() {
		return country;
	}
	public void setCountry(List<String> country) {
		this.country = country;
	}
   
}
