package com.sample.interview.problem;

public class FindEquilibriumPointInAnArray {

	public static void main(String[] args)
	{
		//int nums [] = {1,2,6,4,0,-1};
		//int nums [] = {1,2,6,4,8,1};
		int nums [] = {1,2,6,-4,0,-1};
		findEquilibriumPointInAnArray(nums);
		findEquilibriumPointInAnArrayUsingLessTime(nums);

	}
	
	public static void  findEquilibriumPointInAnArrayUsingLessTime(int nums [])
	{
		if (nums.length < 3) 
		{
		  System.out.println("Value  = -1");
		}
	else
	{
		
		int sumArray [] = new int[ nums.length] ;
		sumArray[0] = nums[0];
		for (int i = 1; i < nums.length; i++) 
		{
			sumArray[i] =sumArray[i-1] +  nums[i];
			//System.out.println(sumArray[i-1] );
		}
		
		int totalSum = sumArray[sumArray.length-1];
		//System.out.println(totalSum);
		int leftSum = 0;
		 int rightSum = 0;
		for (int i = 1; i < nums.length; i++) 
		{
			 leftSum = sumArray[i] - nums[i];
			 rightSum =  totalSum - sumArray [i];
			   if (leftSum == rightSum)
			     {
					  System.out.println(nums[i]);
			     }
		}
	}
}
	
	//Using Brute Force
	public static void  findEquilibriumPointInAnArray(int nums [])
	{
		if (nums.length < 3) 
			{
			  System.out.println("Value  = -1");
			}
		else
		{
			for (int i = 1; i < nums.length; i++) 
			{
				   int leftSum = 0;
				   //Left Sum  
				   for (int j = i-1; j >=0 ; j--) 
				    {
					   leftSum += nums[j];
					} 
				   int rightSum = 0;
				   //Right Sum 
				     for (int j = i+1; j < nums.length; j++) 
				     {
				    	 rightSum += nums[j];
					}
				     
				     if (leftSum == rightSum)
				     {
						  System.out.println(nums[i]);
				     }
			}
		}
		
	}

}
