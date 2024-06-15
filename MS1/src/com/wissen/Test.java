package com.wissen;

public class Test {

	public static void main(String[] args) {	
		//fibonacci series within given range (4,9)
		int start = 44;
		int end = 100;
		int first = 0;
		int second = 1;
		int sum = first + second;
		
		while(sum <= end) {
			if(sum >= start) {
				System.out.println(sum);
			}
			first = second;
			second = sum;
			sum = first+sum;
		}
	}

}
