package com.sample.interview.problem;

public class FindSingleOneDigitFromArray
{

    public static void main(String ...args)
    {
       // int [] nums = {-2,3,2,-1};
        int [] nums = {1,2,7,7,2,8,8};
        int start = 1;
        int end = nums.length - 1 ;
        int maxCurrent = nums[0];

        while(start < nums.length)
        {
            maxCurrent = maxCurrent ^ nums[start++];
            System.out.println(maxCurrent);

        }
        System.out.println("Single Value Array  = "+maxCurrent);

    }
}
