package com.wissen.innerclass;

//static inner class object is created directly without the outer class object
class OuterClass1 {

	int x = 4;
	static int a = 10;
	private static int b = 20;
	
	static class InnerClass {
		void print() {
			System.out.println("a " + a);
			System.out.println("b " + b);
		}
	}
}

public class StaticNestedTestClass {
	
	public static void main(String[] args) {
		OuterClass1.InnerClass innerClassObj = new OuterClass1.InnerClass();
		innerClassObj.print();
	}
}
