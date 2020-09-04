package com.collection.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

	static final class Employee implements Comparable<Employee> {

		private int employeeId;
		private int employeeSalary;
		private String employeeName;

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public int getEmployeeSalary() {
			return employeeSalary;
		}

		public void setEmployeeSalary(int employeeSalary) {
			this.employeeSalary = employeeSalary;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public Employee(int employeeId, int employeeSalary, String employeeName) {
			super();
			this.employeeId = employeeId;
			this.employeeSalary = employeeSalary;
			this.employeeName = employeeName;
		}

		/*@Override
		public int compareTo(Employee o) {
			return this.employeeId - o.getEmployeeId();
		}*/
		
		 @Override
		    public int compareTo(Employee employee) {
		        int result = this.employeeName.compareTo(employee.employeeName);
		        
		        if (result != 0) {
		            return result;
		        }
		        
		        if (result == 0) {
		            result = Integer.compare(this.employeeSalary, employee.employeeSalary);
		        }
		        
		        if (result != 0) {
		            return result;
		        }
		        
		        if (result == 0) {
		            result = Integer.compare(this.employeeId, employee.employeeId);
		        }
		        return result;
		    }

	}

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
		
		Collections.sort(listofEmployee);
		
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
