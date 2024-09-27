package com.wisssen.oops;

import com.wisssen.oops.OuterClass.InnerClass;

//static inner class object is created directly without the outer class object
class OuterClass {

	static int a = 10;
	private static int b = 20;
	
	static class InnerClass {
		void print() {
			System.out.println(a);
			System.out.println(b);
		}
	}
}

public class StaticNestedTestClass {
	
	public static void main(String[] args) {
		OuterClass.InnerClass innerClassObj = new OuterClass.InnerClass();
		innerClassObj.print();
	}
}
