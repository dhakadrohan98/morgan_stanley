package com.wissen.r1.spaceship.oops;

class Parent {

	Parent() {
		this("Constructor");
		System.out.println("Parent Class Default Constructor");
	}

	Parent(String s) {
		System.out.println("Parent Class param  " + s);
	}
}

public class Child extends Parent {

	Child() {
		this("Constructor");
		System.out.println("Child Class Default Constructor");
	}

	Child(String s) {
		System.out.println("Child Class param " + s);
	}

	public static void main(String[] args) {
		Child obj = new Child();
	}

}
