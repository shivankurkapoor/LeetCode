package com.interview.array;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Leet_Longest_String_Without_Repeatition {
public static void main(String[] args) {
	solve("pwwkew");
}

private static void solve(String string) {
	// TODO Auto-generated method stub
	HashMap<Character,Integer> map = new LinkedHashMap<>();
	
	for(int i =0;i<string.length();i++){
		if(map.get(string.charAt(i))!=null){
			map.put(string.charAt(i), (int)(map.get(string.charAt(i)))+1);
		}
		else{
			map.put(string.charAt(i),1);
		}
	}
	
	map.forEach((x,y)->System.out.print(x));
	System.out.println();
	System.out.println(map.size());
}
}
