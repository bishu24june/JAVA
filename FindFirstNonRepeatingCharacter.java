package com.sample.interview.problem;

import java.util.HashMap;

public class FindFirstNonRepeatingCharacter
{
    public static void main(String ...args)
    {
    	String strValue = "aaalldddghhhhhroo";
    	
    	for (int i = 0; i < strValue.length(); i++) 
    	{
		    boolean seenDup = false;
		    for (int j = 0; j < strValue.length(); j++)
		    {
				if (strValue.charAt(i) == strValue.charAt(j) && (i != j))
				{
					seenDup = true;
					break;
				}
			}
		    
		    if(!seenDup)
		    {
		    	System.out.println(strValue.charAt(i));
		    	break;
		    }
		    
		    
		}
    	firstNonRepeatingChar(strValue);
    	firstNonRepeatingCharArray(strValue);
    	firstNonRepeatingCharUsingStringMethod(strValue);
    	
    }
    
    
    private static void firstNonRepeatingChar(String strValue)
    {
    	HashMap<Character,Integer> charCounts = new HashMap<>();
    	
    	for (int i = 0; i < strValue.length(); i++) 
    	{
    		char c = strValue.charAt(i);
    		
    		if(charCounts.containsKey(c))
    		{
    			charCounts.put(c, charCounts.get(c) + 1);
    		}
    		else
    		{
    			charCounts.put(c,1);
    		}
		}
    	
    	for (int i = 0; i < strValue.length(); i++)
    	{
    		char c = strValue.charAt(i);
    		
    		if(charCounts.get(c) == 1)
    		{
    			System.out.println(c);
    			break;
    		}
		}
    }
    
    private static void firstNonRepeatingCharArray(String strValue)
    {
    	int [] charCount = new int[26];
    	for(char c :strValue.toCharArray())
    	{
    		charCount[c - 'a']++;
    	}
    	
    	for(char c :strValue.toCharArray())
    	{
    		if (charCount[c - 'a'] == 1)
    		{
    			System.out.println(c);
    			break;
    		}
    	}
    }
    
    private static void firstNonRepeatingCharUsingStringMethod(String strValue)
    {
    	for (int i = 0; i < strValue.length(); i++) 
    	{
    		System.out.println(strValue.indexOf(strValue.charAt(i)) +" = "+ strValue.lastIndexOf(strValue.charAt(i)));
    		if(strValue.indexOf(strValue.charAt(i)) == strValue.lastIndexOf(strValue.charAt(i)))
    		{
    			System.out.println("firstNonRepeatingCharUsingStringMethod = "+strValue.charAt(i));
    			break;
    		}
    	}
    }
}
