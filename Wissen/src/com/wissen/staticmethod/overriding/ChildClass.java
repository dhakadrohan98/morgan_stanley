package com.wissen.staticmethod.overriding;

/**
 * static method overriden
 */
public class ChildClass extends StaticMethodOverriding {

	public static int sum(int a, int b) {
		return a*b;
	}
	
	public static void main(String[] args) {
		//creating object of parent(StaticMethodOverriding) class
		StaticMethodOverriding parentClassObj = new ChildClass();
		System.out.println(parentClassObj.sum(2, 3)); //5
		
		//creating object of child class
		ChildClass childObj2 = new ChildClass();
		System.out.println(childObj2.sum(2, 3)); //6

	}

}
