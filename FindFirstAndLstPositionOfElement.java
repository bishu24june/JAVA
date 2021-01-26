package com.sample.interview.problem;

public class FindFirstAndLstPositionOfElement 
{

	public static void main(String[] args) 
	{
		int [] nums =  {5,7,7,8,8,10};
		int target = 7; //output [3,4]
		
		/*
		 * int [] nums =  {5,7,7,8,8,10};
			int target = 6; //output [-1,-1]
		 */
		
		   int result [] = new int [2];
		   
		   result[0] = findFirstIndex(nums,target) ;
		   result[1] =findLastIndex(nums,target);
		   
		   System.out.println("Position Would be = "+result[0] +" And "+ result[1] );
		
	}
	
	public static int findFirstIndex(int [] nums,int target)
	{
		int index = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) 
		{
				int midPoint = start + (end - start)/2;
				if(nums[midPoint] >= target)
				{
					 end =    midPoint -1;
				}
				else
				{
					start =    midPoint + 1;
				}
				
				if(nums[midPoint] == target) index = midPoint;
				
		}
		return index;
	}
	
	public static int findLastIndex(int [] nums,int target)
	{
		
		int index = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) 
		{
				int midPoint = start + (end - start)/2;
				if(nums[midPoint] <= target)
				{
					 
					 start =    midPoint + 1;
				}
				else
				{
					end =    midPoint -1;
				}
				
				if(nums[midPoint] == target) index = midPoint;
				
		}
		return index;
	}

}
