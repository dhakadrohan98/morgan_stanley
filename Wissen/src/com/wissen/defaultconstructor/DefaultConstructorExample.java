package com.wissen.defaultconstructor;

class Student {
	String name;
	int age;
	
	// No explicit constructor defined, so the compiler provides a default constructor
}

public class DefaultConstructorExample {
	
	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("Student name " + student.name);
		System.out.println("Age: " + student.age);

	}
}
