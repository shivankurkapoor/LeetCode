package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class Leet_NQeens {
	static int board[][];
	static List<List<String>> configs;
	public static void main(String...args){
		int n =4;
		board = new int[n][n];
		configs = new ArrayList<>();
		solveNQeens(n,0);
System.out.println();
	}
	private static void solveNQeens(int n,int col) {
		if(col>=n){
			put(board,n);
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
	private static void put(int[][] board, int n) {
		StringBuilder temp;
		List<String> temp1 = new ArrayList<>();
		for(int i=0;i<n;i++ ){
			temp = new StringBuilder();
			temp.append("\"");
			for(int j=0;j<n;j++){
				if(board[i][j]==0)
					temp.append(".");
				else
					temp.append("Q");
			}
			temp.append("\""+System.lineSeparator());
		temp1.add(temp.toString());	
		}
		configs.add(temp1);
		

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
