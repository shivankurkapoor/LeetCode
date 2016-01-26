package com.interview.array;

public class Leet_Kth_Permutation {
	int nums[];
	boolean mark[];
public static void main(String...args){
	System.out.println(new Leet_Kth_Permutation().kthPermutation(3, 4));
}

public int find(int n,int k){
    int cnt=0;
    for(int i=1;i<=n;i++){
        if(mark[i]==false){
            cnt++;
        }
        if(cnt==k) return i;
    }
    return 0;
}
public String kthPermutation(int n, int k) {
    char[] array = new char[n];
    int t=0;
    int p=0;
    nums = new int[n+1];
    mark = new boolean[n+1];
    nums[0]=1;
    for(int i=1;i<=n;i++){
        nums[i]=i*nums[i-1];
    }
    for(int i=0;i<n;i++){
        t=(k-1)/nums[n-i-1];
        p=find(n,t+1);
        array[i]=(char) ('0'+p);
        mark[p]=true;
        k=k-t*nums[n-i-1];
    }  
    String s=String.copyValueOf(array);
    return s;
 }
}
