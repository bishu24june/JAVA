package com.sample.interview.problem;

import java.util.HashSet;

public class FindLongestSubarrayBySum
{

    public static void main(String ...args)
    {
    	  int [] nums = {1,2,3,4,5,0,0,0,0,8,7,8,9,10};
    	  //int [] nums = {10,20,30,40,0,0,0,0,0,80,70,8,9,10};
          int start = 0;
          int end = 0;
          int length = nums.length;
          int maxSum = 0;
          int target = 15;

          int [] result = new int[] {-1};
          
          //Add up to k position array values
          while (end < length)
          {
        	  maxSum = maxSum + nums[end];
              //System.out.println("windowSum = "+windowSum);
        	  
        	  while(start < end && maxSum > target)
              {
        		  maxSum = maxSum - nums[start++];
              }
        	  
        	  if (maxSum == target && (result.length ==1 || (result[1] - result[0]) < (end - start)))
        	  {
        		  result = new int [] {start + 1, end + 1};
        	  }
        	  
        	  end++;
        	  
          }
          
          if(result.length == 2)
          
        	  		System.out.println("Array Position Max Sum = "+result[0]+" "+result[1]);
          
          else 
        	  
  	  		System.out.println("Array Position Max Sum Not Present");
    }
}
