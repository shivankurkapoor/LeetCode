package com.interview.array;

public class Leet_NQeensII {
	static int board[][];
	static int count = 0;
	public static void main(String...args){
		int n =2;
		board = new int[n][n];
		solveNQeens(n,0);
		System.out.println(count);

	}
	private static void solveNQeens(int n,int col) {
		if(col>=n){
			count++;
			return;
		}
		for(int row=0;row<n;row++){
			if(isSafe(row,col,n)){
				board[row][col] = 1;
				solveNQeens(n,col+1);
				board[row][col] = 0;
			}
		}

	}
	private static boolean isSafe(int i, int j,int n) {
		// TODO Auto-generated method stub

		int k,l;
		for(k=j;k>=0;k--)
			if(board[i][k]==1)
				return false;

		for(k=i,l=j;k>=0&&l>=0;k--,l--){
			if(board[k][l]==1)
				return false;
		}
		for(k=i,l=j;k<n&&l>=0;k++,l--){
			if(board[k][l]==1)
				return false;
		}
		return true;
	}
}
