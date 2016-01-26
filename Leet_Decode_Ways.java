package com.interview.array;

public class Leet_Decode_Ways {
public static void main(String[] args) {
	System.out.println(solve("123911"));
}

private static long solve(String s) {
	// TODO Auto-generated method stub
     
     if(s==null||s.length()==0)
    	 return 0;
     if(s.length()==1&&s.charAt(0)>='1'&&s.charAt(0)<='9')
    	 return 1;
     if(s.charAt(0)=='0')
    	 return 0;
     int ways[] = new int[s.length()];
    ways[s.length()-1] = s.charAt(s.length()-1)=='0'?0:1;
    
    for(int i =s.length()-2;i>=0;i--){
    	if(s.charAt(i)=='0'){
    		if(s.charAt(i+1)=='0')
    			return 0;
    		else 
    			continue;
    	}
    	ways[i] = ways[i+1];
    	if((s.charAt(i)=='1')||(s.charAt(i)=='2'&&s.charAt(i+1)<'7')){
    		ways[i]+=i+2>s.length()-1?1:ways[i+2];
    	}
    }
    return ways[0];
}
}
