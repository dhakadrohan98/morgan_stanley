package com.wissen.staticmethod.overriding;

/**
 * Q.2) can you access an instance variable from a static method?
 */
public class StaticMethodOverriding {

	int x = 0;
	
	
	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		//instance of StaticMethodOverriding class
		StaticMethodOverriding obj = new StaticMethodOverriding();
		
		//
		StaticMethodOverridingExample2 obj1 = new StaticMethodOverridingExample2();
		int y = obj1.y;
		System.out.println(y);
		
	}

}
