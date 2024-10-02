package com.wissen.hashcode.equals.method;


public class StudentHashCodeEqualsMethodDemo {
	
	public static void main(String[] args) {
		Student student1 = new Student(1, "rohan", 16);
		Student student2 = new Student(1, "rohan", 1);
		System.out.println(student1.hashCode());
		System.out.println(student2.hashCode());
		
		System.out.println(student1.equals(student2));
	}	
}
