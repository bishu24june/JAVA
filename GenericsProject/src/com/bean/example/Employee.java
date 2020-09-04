package com.bean.example;

import java.io.Serializable;

public class Employee implements Serializable{
	
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
	
	
	

}
