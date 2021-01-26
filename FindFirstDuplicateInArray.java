package com.sample.interview.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindFirstDuplicateInArray {

	public static void main(String... args) {
		// int [] nums = {-2,3,2,-1};
		int[] nums = { 1, 9, 3, 2, 7, 3, 1, 2 };
		int start = 0;
		int end = nums.length;
		HashSet<Integer> dup = new HashSet<>();

		while (start < end) {
			if (dup.contains(nums[start])) {
				System.out.println(nums[start]);
				break;
			} else {
				dup.add(nums[start]);
			}
			start++;

		}

		findDupElement(nums, end);

	}

	private static void findDupElement(int[] nums, int length) {

		// Find Max
		int max = nums[0];
		for (int i = 1; i < length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		System.out.println(max);

		int a[] = { 0 };
		int b[] = { 0 };
		int k = 0;
		for (int i = 0; i < length; i++) {

			// Duplicate element found
			if (a[nums[i]] > 0) {
				b[nums[i]] = 1;
				k = 1;
				continue;
			} else {
				// storing 1st occurence of arr[i]
				a[nums[i]] = i;
			}
		}

		if (k == 0)
			System.out.println("No repeating element found");
		else {
			int min = max + 1;

			// trace array a & find repeating element
			// with min index
			for (int i = 0; i < max + 1; i++)
				// if ((a[i] && min) > (a[i] && b[i]))
				// min = a[i];
				System.out.println(nums[min]);
		}
	}
}