package com.wissen.oops.interview.problems;

class Parent {
	public static void greet() {
		System.out.println("greeting from parent!");
	}
	
	public static int sum(int a, int b, int c) {
		return a+b+c;
	}
	
	public static int sum(int a, int b) {
		return a+b;
	}
}

class Child extends Parent {

	public static void greet() {
		System.out.println("greeting from child!");
	}
}

public class StaticMethodOverriddingClient {

	public static void main(String[] args) {
		Parent.greet();
		Child.greet();
		/*
		 * Reason: static method are never ever overridden, Unlike instance methods, which
		 * are resolved at runtime, static methods are resolved at compile time.
		 */
		
		System.out.println(Parent.sum(1, 2));
		System.out.println(Parent.sum(1, 2, 3));
	}
}
