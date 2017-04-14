package com.collection.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bean.example.Employee;

class EmployeeId implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getEmployeeId() - o2.getEmployeeId() ;
	}
	
}

class EmployeeName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getEmployeeName().compareTo(o2.getEmployeeName()) ;
	}
	
}
public class ComparatorTest {
	public static void main(String[] args) {
		Employee employee1 = new Employee(19,2000,"Bishwa");
		Employee employee2 = new Employee(1,5000,"Yatin");
		Employee employee3 = new Employee(79,1000,"Mukesh");
		Employee employee4 = new Employee(13,8000,"Ajay");
		
		List<Employee> listofEmployee = new ArrayList<>();
		listofEmployee.add(employee1);
		listofEmployee.add(employee2);
		listofEmployee.add(employee3);
		listofEmployee.add(employee4);
		
		//Collections.sort(listofEmployee,new EmployeeId());
		
		Collections.sort(listofEmployee,new EmployeeName());
		
		for (Employee employee : listofEmployee) {
			System.out.print(employee.getEmployeeId()+" ");
			System.out.print(employee.getEmployeeSalary()+" ");
			System.out.println(employee.getEmployeeName());
		}
		
		/*for (Employee employee : listofEmployee) {
			System.out.println(employee.getEmployeeSalary());
		}
		
		for (Employee employee : listofEmployee) {
			System.out.println(employee.getEmployeeName());
		}
		*/
		

	}

}
