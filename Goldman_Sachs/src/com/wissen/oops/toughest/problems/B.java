package com.wissen.oops.toughest.problems;

class A {
	int i;

	public A(int x) {
		this.i = x;
	}
}

public class B extends A {
	int j;
	
	//Implicit super constructor A() is undefined. Must explicitly invoke another constructor
//	public B() {}
	
//	public B(int y) {
//		super(2*y);
//		this.j = y;
//	}
	
//	public B(int z) {
//		this(z, z);
//	}
	
	public B(int x, int y) {
		super(x);
		this.j = y;
	}
	
	public static void main(String[] args) {
		B obj = new B(1,5);
	}
}
