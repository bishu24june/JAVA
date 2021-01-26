package com.sample.interview.problem;

public class TwoPointerTechniqueOppositeDirection
{

    public static void main(String ...args)
    {
        int [] nums = {-3,2,1,3,6,8,15};
        int start = 0;
        int end = nums.length-1;
        int [] results =new int[2] ;
        int target = 14;
        //Pointer moves opposite direction
        while (start < end)
        {
            int sum = nums[start] + nums[end];
            if(sum == target)
            {
                results [0] = start+1;
                results [1] = end+1;
                break;
            }
            else if (sum > target)
            {
                    end--;
            }
            else
            {
                    start++;
            }
        }

        System.out.println("Array position = "+results [0] +" And "+ results [1]);
        System.out.println("Array position Values = "+nums[results [0]-1] +" And "+ nums[results [1]-1]);

    }
}
