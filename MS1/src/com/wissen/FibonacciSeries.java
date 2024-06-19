package com.wissen;

public class FibonacciSeries {

	//  start,end <= Integer.MAX_VALUE;
	//0,1,1,2,3,5,8
	
	// 4,9
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start =16;
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
		System.out.println("end of the program");
			
		
	}

}
