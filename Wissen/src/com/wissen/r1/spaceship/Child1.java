package com.wissen.r1.spaceship;

class Parent1 {

	Parent1() {
		this("Constructor");
		System.out.println("Parent class Default Constructor");
	}

	Parent1(String s) {
		System.out.println("Parent Class Param  " + s);
	}
}

public class Child1 extends Parent1 {

	Child1() {
		super("Constructor");
		System.out.println("Child Class Default Constructor");
	}

	Child1(String s) {
		System.out.println("Child Class Param Constructor " + s);
	}

	public static void main(String[] args) {
		Child1 obj = new Child1();
	}
}
