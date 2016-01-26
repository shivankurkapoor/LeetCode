package com.interview.array;

class RMQ{

	int arr[];
    public RMQ(int[] nums) {
    	arr = new int [nums.length+1];
        arr[0] = 0;
        for(int i = 0;i<nums.length;i++){
        	updateInit1(i,nums[i]);
        }
    }
    
    void updateInit1(int i, int val){
    	i += 1;
        int len = arr.length;
        for (; i < len; i  = i + (i&-i)){
        	arr[i] += val;
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

public class Leet_RMQImmutable {
public static void main(String...args){
	int arr[] = {1,2,3,4};
	RMQ obj = new RMQ(arr);
	System.out.println(obj.sumRange(0, 3));
}
}
