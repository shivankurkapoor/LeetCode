package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int n = (int) Math.pow(2,nums.length);
		int m = nums.length;
		for(int i =0;i<n;i++){
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=0;j<m;j++){
				if((i&1<<j)==(1<<j))
					temp.add(nums[j]);
			}
			list.add(temp);
		}
		
		return list;

	}
	public static void main(String...args){
     int arr[] = {1,2};
     List<List<Integer>> l = subsets(arr);
     for(List<Integer> x:l){
    	 x.forEach(ele -> System.out.print(ele+" "));
    	 System.out.println();
     }
	}
}
