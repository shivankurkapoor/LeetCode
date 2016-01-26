package com.interview.array;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Leet_Fraction {
	static String fractionToDecimal(int numerator, int denominator) {
		long num = (long) numerator;
		long den = (long) denominator;
		StringBuilder res = new StringBuilder();
		if((num<0&&den>0)||(num>0&&den<0))
			res.append("-");
		num = Math.abs(num);
		den = Math.abs(den);
		long quo = num/den;
		long rem = num%den;
		Map<Long,Boolean> map = new java.util.LinkedHashMap<>();
		
		res.append(String.valueOf(quo));
	    int multi=0;	
		if(rem!=0){
			res.append(".");
			while(rem!=0){
				multi = findMultipler(rem,den);
				quo = (rem*multi)/den;
				if(map.containsKey(quo)){
					map.put(quo,true);
					break;
				}


				map.put(quo,false);
				rem = (rem*multi)%den;
			}

			Set<Entry<Long, Boolean>> set = map.entrySet();
			boolean flag = true;
			for(Map.Entry<Long, Boolean> x : set){
				if(!x.getValue()){
					res.append(x.getKey());
				}
				else{
					flag = false;
					res.append("(");
					res.append(x.getKey());
				}

			}
			if(flag==false)
				res.append(")");
		}
		String temp = "";
		for(int i=0;i<String.valueOf(findMultipler(num%den, den)).length()-2;i++)
			temp = temp.concat(String.valueOf(0));
		
//		if(res.toString().contains(".(")){
//			res.insert(res.indexOf(".(")+2,temp);
//		}
//		else
			res.insert(res.indexOf(".")+1, temp);	
		
		return res.toString();
	}

	private static int findMultipler(long rem, long den) {
		// TODO Auto-generated method stub
		if(rem==0)
			return 0;
		int i =1;
		while(rem<den)
			{
			   i *=10;
			   rem = rem*10;
			}
		return i;
	}

	public static void main(String...args){
		int n =1,d =333;
		System.out.println(fractionToDecimal(n, d));

	}
}
