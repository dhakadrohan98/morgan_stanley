package com.wissen.enumexample;

enum Employee {
	Mike(15), John(20), Lisa(12), Dave(25);

	private int age;

	private Employee(int age) {
		this.age = age;
		System.out.println("Constructor called for : " + this.toString());
	}
	
	int getAge() {
		return age;
	}
}

public class EnumTestClass {

	public static void main(String[] args) {
		System.out.println(Employee.Lisa.getAge());

	}

}
