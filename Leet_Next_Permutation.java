package com.interview.array;

import java.util.Arrays;



public class Leet_Next_Permutation {
public static void main(String...args){
	int nums [] = {5,1,1};
	nextPermutation(nums);
}

private static void nextPermutation(int[] nums) {
	// TODO Auto-generated method stub
	int i;
	for(i = nums.length-1;i>=1;){
		if(nums[i]<=nums[i-1])
		    i--;
		else
			break;
	}
	if(i==0)
		Arrays.sort(nums);
	else{
		 i--;
		int justBig = i+1;
		for(int j = i+2;j<nums.length;j++){
			if(nums[j]>nums[i]&&nums[j]<nums[justBig])
				justBig = j;
		}
		
		int temp = nums[i];
		nums[i] = nums[justBig];
		nums[justBig] = temp;
		Arrays.sort(nums, i+1,nums.length);
	}
		
	
}
}
