package com.wisssen.oops;

public class MethodOverloadingExample {

	static void print(int a, int b) {
		System.out.println(a +" " + b);
	}
	
	public static void print(double a, double b) {
		System.out.println(a +" " + b);
	}
	
	public static void main(String[] args) {
		long num = 5;
		print(300000, 4);
	}

}
