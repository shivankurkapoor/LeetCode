package com.interview.array;

public class Leet_MssingNumber {
	  public static int[] singleNumber(int[] nums) {
		    if(nums==null||nums.length==0)
		       return new int[0];
		    int[] a=new int[2];
		    int t1=0,t2=0,n=nums.length,t=0,s=1;
		    for(int i=0;i<n;i++)
		       t^=nums[i];

		       while((t&s)==0){//
		           s=s<<1;
		       }

		      for(int i=0;i<n;i++){
		          if((nums[i]&s)==0)
		            t1^=nums[i];
		          else if((nums[i]&s)!=0)
		            t2^=nums[i];
		      }
		      a[0]=t1;
		      a[1]=t2;
		      return a;    
		}
	public static void main(String...args){
	int arr[] = {1,1,2,2,3,3,4,8};
	int r[] = singleNumber(arr);
	System.out.println(r[0]+"  "+r[1]);
}
}
