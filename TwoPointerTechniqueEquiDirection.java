package com.sample.interview.problem;

import java.util.HashSet;

//The Problem
/* You have two integer arrays,a and b and an integer target values v.Determine whether there is pair of 
 * numbers, where one numbers is taken from a and the other from b that can be added together to get a sum
 * of v.Retrun true if  such a pair exists otherwise return false. 
 * 
 */
public class TwoPointerTechniqueEquiDirection
{

    public static void main(String ...args)
    {
        int [] A = {1,9,-1,-2,7,3,-1,2};
        int [] B = {1,6,-1,6,7,4,7,2};
        int v = 14;
        //brute force
        for (int i = 0; i < A.length; i++)
        {
        	int needed_value = v - A[i]; 
           for (int j = 0; j < B.length; j++)
           {
        	   if(B[j] == needed_value)
        	   {
        		   System.out.println("Brute force result = " + "True");
        		   break;
        	   }
        		   
           }
			
		}	
        //reduced time complexity 
        sumOfTwo(A,B,v);
    }

    private static void sumOfTwo(int [] A,int [] B,int v)
    {
    	HashSet<Integer> diffs = new HashSet<>();
    	
    	for (int i = 0; i < A.length; i++) 
    	{
		         int diff = v - A[i];
		         diffs.add(diff);
		         
		}
    	
    	for (int i = 0; i < B.length; i++) 
    	{
		    if(diffs.contains(B[i]))
		    {
		    	System.out.println("Reduced time complexity  result = " + "True");
		    	 break;
		    }
		}
    }
}
