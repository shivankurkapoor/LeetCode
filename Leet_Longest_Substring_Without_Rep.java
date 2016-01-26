package com.interview.array;

import java.util.HashMap;

public class Leet_Longest_Substring_Without_Rep {
	public static void main(String[] args) {
		System.out.println(solve("aba"));
	}

	private static int solve(String string) {
		// TODO Auto-generated method stub

		if(string == null||string.length()==0)
			return 0;
		int arr[] = new int [string.length()];
		arr[0] = 1;
		HashMap<Character,Integer> map = new HashMap<>();
		map.put(string.charAt(0),0);
		int j =0;
		for(int i =1;i<string.length();i++){
			if(!map.containsKey(string.charAt(i))){
				arr[i] = Math.max(arr[i-1],i - j+1);
				map.put(string.charAt(i),i);
			}
			else{
				if(map.get(string.charAt(i))>=j){
					j = map.get(string.charAt(i))+1;
					arr[i] = arr[i-1];	
				}
				else{
					arr[i] = Math.max(arr[i-1],i - j+1);
				}
				map.put(string.charAt(i),i);
			}
		}

		return arr[string.length()-1];

	}
}
