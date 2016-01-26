package com.interview.array;

public class Leet_Kth_Perm {
	boolean bool[];
	public static void main(String...args){
		System.out.println(new Leet_Kth_Perm().kthPerm(3, 4));
	}

	private String kthPerm(int n, int k) {
		// TODO Auto-generated method stub
		bool = new boolean[n+1];
		int perm[] = new int [n+1];
		char arr[] = new char[n];
		perm[0] =1;
		int nth = 0;
		int p=0;
		for(int i =1;i<n+1;i++)
			perm[i] = i*perm[i-1];
		for(int i =0;i<n;i++){
			nth = (k-1)/perm[n-i-1];  //(k-1)/(n-1)!
			p = find(n,nth+1);
			bool[p] = true;
			arr[i] = (char)('0'+p);
			k = k - nth*(perm[n-i-1]);
		}
		return new String(arr);
	}

	private int find(int n, int x) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i =1 ;i<=n;i++){
			if(bool[i]==false)
				count++;
			if(count==x) return i;
		}
		return 0;
	}
}
