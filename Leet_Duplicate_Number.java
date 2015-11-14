package com.interview.array;

public class Leet_Duplicate_Number {
public static void main(String...args){
	int arr[] = {1,2,3,1,4,5};
	solve(arr);
}

private static void solve(int[] arr) {
	// TODO Auto-generated method stub
	int fast=arr[arr[0]];
	int slow=arr[0];
	while(fast!=slow){

		fast = arr[arr[fast]];
		slow = arr[slow];
	}
	
	fast = 0;
	while(slow!=fast){
		slow = arr[slow];
		fast = arr[fast];
	}
	System.out.println(fast);
}
}
