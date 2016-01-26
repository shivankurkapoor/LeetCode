package com.interview.array;

public class Leet_RepeatingNumbersThree {
static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        int common_bistmask;
        for(int i = 0;i< nums.length;i++){
        	twos = twos|(ones&nums[i]);
        	ones = ones ^ nums[i];
        	common_bistmask = ~(ones&twos);
        	ones &= common_bistmask;
        	twos &= common_bistmask;	
        }
        
        return ones;
    }
public static void main(String...args){
	int arr[] = {2,2,2,4,4,5,4,6,7,6,7,6,7};
	System.out.println(singleNumber(arr));
}
}
