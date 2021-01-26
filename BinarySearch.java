package com.sample.interview.problem;

public class BinarySearch {

	public static void main(String[] args)
	{
				//For binary search sorting is mandatory
				int [] nums = {12,23,34,45,51,67,70};
				int target = 67;
				int length = nums.length - 1 ;
				binarySearch(nums,length,target);
	}
	
	public static void binarySearch(int [] nums ,int high,int target)
	{
			int low = 0, mid = 0;
			
			while(low <= high)
			{
				mid = low + (high - low) /2;
				
				System.out.println("Mid = "+mid + " Low  = "+low+" High = "+high+" Mid Value = "+nums[mid]);
				
				if (target  == nums[mid]) System.out.println("Search Value = "+target);
				
				if (target  < nums[mid]) 
					high = mid - 1;
				else
					 low = mid + 1;
			}
	}

}
