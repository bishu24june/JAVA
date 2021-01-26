package com.sample.interview.problem;

public class FindLongestPalindrome
{
	
	public static void main(String[] args)
	{
		  String palinStr = "rac a car";
		  String palinStr1 = "a man, a plan, a canal: panama";
		 String palinStr2 = "abqba";
		 String palinStr3 = "raceacar";
		longestPlindrome(palinStr2.trim());
		
	}
		

    //Brute Force
	public static void longestPlindrome(String palinStr)
	{
		 int startPoint = 0;
		 int endPoint = palinStr.length() - 1;
		 boolean flag = false;
		 while (startPoint <=  endPoint)
		 {
			 System.out.println(startPoint+"######"+endPoint);
			 if (palinStr.charAt(startPoint) == palinStr.charAt(endPoint))
			 {
				 startPoint++;
				 endPoint--;
				 flag = true;
			 } 
			 else
			 {
				 if(!(palinStr.charAt(startPoint) >= 'a' && palinStr.charAt(startPoint) <= 'z' )) 
				 {
					 startPoint++;
				 }
				 else
				 {
					 flag = false;
				 }
				 if((palinStr.charAt(endPoint) >= 'a' && palinStr.charAt(endPoint) <= 'z')) 
				 {
					 endPoint--;
				 }
				 else 
				 {
					 flag = false;
				 }
			 }
						
			
		 }
		 
		 if (flag)
		 {
			 System.out.println("Palindrom");
		 }
		 else
		 {
			 System.out.println("Not Palindrom");
		 }
		
		
	}
}
