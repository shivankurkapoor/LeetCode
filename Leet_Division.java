package com.interview.array;

public class Leet_Division {
	public static int divide(int dividend, int divisor) {
		int sign =1;
		if(dividend==0||Math.abs((long)dividend)<divisor)
			return 0;

		if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
			sign = -1;
		}
		
		long divid = Math.abs((long)dividend);
		long divis = Math.abs((long)divisor);
		if(divis==1){
			long temp = Math.abs((long)(dividend/divisor))*sign;
	         if(temp>Integer.MAX_VALUE)
	        	 return Integer.MAX_VALUE;
	         else if(temp<Integer.MIN_VALUE)
	        	 return Integer.MIN_VALUE;
	         else
	        	 return (int) (temp);
		}

		long result = 0;
		while(divid>=divis){
	        long tmp=divis,count=1;;
	        while(tmp<=divid){
	            tmp=tmp<<1;
	            count=count<<1;
	        }
	        tmp=tmp>>1;
	        count=count>>1;
	        result+=count;
	        divid-=tmp;
	    }	
			if(result>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return (int) result*sign;	
	}
	public static void main(String...args){
		int a = -2147483648,b =-1 ;
		System.out.println(divide(a,b));
	}
}
