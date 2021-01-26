package com.sample.interview.problem;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args)
	{
	    Scanner in = new Scanner(System.in);  
	    System.out.print("Enter your Age: ");  
        int age = in.nextInt();  
        System.out.println("Age is: " + age);
        in.nextLine();  
        System.out.print("Enter your name: ");  
        String name = in.nextLine();  
        System.out.println("Name is: " + name);             
        in.close();             

	}

}
