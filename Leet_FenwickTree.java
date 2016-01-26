package com.interview.array;

class NumArray {

	int arr[];
	int brr[];
    public NumArray(int[] nums) {
    	brr = nums;
        arr = new int [nums.length+1];
        arr[0] = 0;
        for(int i = 0;i<nums.length;i++){
        	updateInit(i,nums[i]);
        }
    }

    void updateInit(int i, int val){
    	i += 1;
        int len = arr.length;
        for (; i < len; i  = i + (i&-i)){
        	arr[i] += val;
        }
    }
    void update(int i, int val) {
    	i += 1;
    	int diff = val - brr[i-1];
    	brr[i-1] = val;
    	int len = arr.length;
        for (; i < len; i  = i + (i&-i)){
        	arr[i] += diff;
        }
    }

    public int sumRange(int i, int j) {
    	i = i+1;
    	j = j+1;
        int sum1 = 0,sum2 = 0,k = i-1;
        for(;k>0;k = k- (k&(-k))){
        	sum1+= arr[k];
        }
        for(;j>0;j = j- (j&(-j))){
        	sum2 +=arr[j]; 
        }
        
        return sum2-sum1;
    }
}

public class Leet_FenwickTree {
public static void main(String...args){
	int arr[] = {7,2,7,2,0};
	NumArray obj = new NumArray(arr);
	System.out.println(obj.sumRange(0,arr.length-1));
	obj.update(4,6);
	System.out.println(obj.sumRange(0,arr.length-1));
	obj.update(0,2);
	System.out.println(obj.sumRange(0,arr.length-1));
	obj.update(0,9);
	System.out.println(obj.sumRange(0,arr.length-1));
//	System.out.println(obj.sumRange(4,4));
//	obj.update(3, 8);
//	System.out.println(obj.sumRange(0, 4));
//	
//	System.out.println(obj.sumRange(0,arr.length-1));
	
}
}
