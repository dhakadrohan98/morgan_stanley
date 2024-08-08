package com.wissen.CollectionsFramework;

public class WrapperClassExample {

	public static void main(String[] args) {
		Integer it1 = new Integer(10);
		Integer it2 = new Integer(7);
		int compareTo = Integer.compare(-30, -31);
		System.out.println(compareTo);
		
		int num = Integer.parseInt("2");
		System.out.println(num);
		
		//Autoboxing
		//convert wrapper class into primitive types
		int num2 = it1;
		System.out.println(num2);
		
		//Unboxing
		//convert primitive types into wrapper class
		Integer it3 = 15;
		System.out.println(it3.getClass());
		

	}

}
