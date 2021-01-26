package com.sample.interview.problem;

import java.util.HashMap;
import java.util.Stack;

public class FindNextGreaterElementInAllElement
{

    public static void main(String ...args)
    {
        int [] nums = {13,7,6,12,10};
      // int [] nums = {1,9,3,7,4,2,6};
    	// int [] nums = {18,7,6,12,15};
        findTheNextElementInAllArray(nums,nums.length);
        findTheNextElementInAllArrayLessTime(nums,nums.length);
    }
    private static void findTheNextElementInAllArrayLessTime(int [] nums, int length)
    {
    	Stack <Integer> s = new Stack<Integer>(); 
    	HashMap<Integer,Integer> nextGreater = new HashMap<>();
    	
    	for (Integer n : nums)
    	{
    		while (!s.empty() && s.peek() < n) 
    		{
    			nextGreater.put(s.pop(),n);
    			//System.out.println("nextGreater = "+nextGreater);
    		}
    		s.push(n);
    	}
    	//System.out.println("nextGreater = "+nextGreater);
    	for (int i = 0; i < nums.length; i++) 
    	{
    		
    		nums[i] = nextGreater.getOrDefault(nums[i], -1);
    		System.out.println("---"+nums[i]);
		}
    	System.out.println("*********************************************************");

    	
    }
    
    //Brute Force algo
    private static void findTheNextElementInAllArray(int [] nums, int length)
    {
    	     
    		for (int i = 0; i < length; i++) 
    		{
    				int nextGreater = nums[i];
    				int greater = -1;
    				for (int j = i; j < length; j++)
    				{
							 if (nextGreater < nums[j])
							 {
								 nextGreater =  nums[j];
								
								 break;
							 }
						}
    				 if (nums[i] == nextGreater)
					 {
						 nextGreater = -1;
					 }
    				System.out.println(nums[i] + " = "+nextGreater);
			}
    		
    		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}




