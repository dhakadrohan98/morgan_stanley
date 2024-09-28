package com.wissen.classloader;

public class Employee {

	public static void main(String[] args) {
		System.out.println(Employee.class.getClassLoader());
		System.out.println(System.class.getClassLoader());
	}
}
