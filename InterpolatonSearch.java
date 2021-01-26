package com.sample.interview.problem;

public class InterpolatonSearch {

	public static void main(String[] args)
	{
				//For binary search sorting is mandatory
				int [] nums = {12,23,51,67,70,34,45};
				int target = 67;
				int length = nums.length - 1 ;
				interpolatonSearch(nums,length,target);
	}
	
	public static void interpolatonSearch(int [] nums ,int high,int target)
	{
			int low = 0, mid = 0;
			
			while(low <= high)
			{
				System.out.println("Mid = "+mid + ", Low  = "+low+", High = "+high+", nums[mid] = "+nums[mid]+", nums[low] = "+nums[low]+", nums[high] = "+nums[high]);
				mid = low + (high - low) * ((target - nums[low])/(nums[high] - nums[low]));
				

				
				if (target  == nums[mid]) System.out.println("Search Value = "+target);
				
				if (target  < nums[mid]) 
					high = mid + 1;
				else
					 low = mid - 1;
			}
	}

}
