package com.wissen.oops.interview.problems;

class Parent {
	public static void greet() {
		System.out.println("greeting from parent!");
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
		 * Reason: static method never ever overridden, Unlike instance methods, which
		 * are resolved at runtime, static methods are resolved at compile time.
		 */
	}
}
