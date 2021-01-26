package com.sample.interview.problem;

public class FindMaxSubArrayKandanesAlgo
{

    public static void main(String ...args)
    {
       // int [] nums = {-2,3,2,-1};
        int [] nums = {1,9,-1,-2,7,3,-1,2};
        int start = 0;
        int end = nums.length - 1 ;
        int maxGlobal = nums[0];
        int maxCurrent = nums[0];

        //Kandane's Algorithm
        while(start < nums.length)
        {
            maxCurrent = Math.max(nums[start],maxCurrent + nums[start]);
            if (maxCurrent > maxGlobal)
            {
                maxGlobal = maxCurrent;
            }
            start++;

        }
        System.out.println("Array position Max Value = "+maxGlobal);

    }
}
