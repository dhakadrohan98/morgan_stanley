package com.wissen.r1.spaceship.OOPS;

class Parent1 {
	
//	Parent1() {
//		System.out.println("Parent class default constructor ");
//	}
	
	Parent1(String s) {
		System.out.println("Parent Class Param  " + s);
	}
}

public class Child11 extends Parent1 {

	Child11() {
		this("Constructor");
		System.out.println("Child Class Default Constructor");
	}

	Child11(String s) {
//    	super(s);
		System.out.println("Child Class Param Constructor " + s);
	}

	public static void main(String[] args) {
		Child11 obj = new Child11();
	}

}

//nums1 = {1,2,0,3,0,4,0,7};
//nums2 = {4,6,7,0,9,0,0,9,9,10,11};
