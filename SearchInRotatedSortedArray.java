package com.sample.interview.problem;

public class SearchInRotatedSortedArray 
{
	
	public static void main(String[] args) 
	{
		//Input nums = [4,5,6,7,8,0,1,2] , target = 0
		//Output = 4
		
		int nums [] = {4,5,6,7,8,0,1,2} , target = 0;
		
		//Input nums = [4,5,6,7,8,0,1,2] , target = 3
			//Output = -1
		search(nums,  target);
		System.out.println("Exiting the program");
	}
	
	public static void search(int []nums, int target)
	{
		int left = 0;
		int right = nums.length - 1;
		int mid;
		
		if (nums == null || nums.length  == 0)  System.out.println("Not a valid array");
		
		while (left <= right)
		{
			int midPoint = (right + left) /2;
			
			if (nums[midPoint] == target)
			{
				System.out.println(midPoint);
			}
			else if (nums[midPoint]  >= nums[left]  )
			{
				if (target <= nums[midPoint] && target >=  nums[left] )
				{
					right = midPoint - 1;
				}
				else
				{
					left = midPoint + 1;
				}
				
			}
			else 
			{
				if (target >= nums[midPoint] && target <=  nums[right] )
				{
					left = midPoint + 1;
				}
				else
				{
					right = midPoint - 1;
				}
			}
		
		}
	}

}
