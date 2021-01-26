package com.sample.interview.problem;

public class SumOFTwoArrayValuesAndFindTheTargetValue
{

    public static void main(String ...args)
    {
        int [] nums = {1,9,-1,-2,7,3,-1,2};
        int start = 0;
        int end = 0;
        int k = 4;
        int windowSum = 0;
        int maxSum = 0;

        //Add up to k position array values
        while (end < k)
        {
            windowSum = windowSum + nums[end++];
            System.out.println("windowSum = "+windowSum);
        }
        //Pointer moves Equi direction
        while(end < nums.length)
        {
            windowSum = windowSum + nums[end++] - nums[start++];
            maxSum = Math.max(maxSum,windowSum);
        }
        System.out.println("Array position Max Value = "+maxSum);

    }
}
