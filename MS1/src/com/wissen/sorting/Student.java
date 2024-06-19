package com.wissen.sorting;

import java.util.*;
public class Student implements Comparable<Student> {
	
	int id;
	String name;
	int age;
	int grade;
	
	public Student(int id, String name, int age, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Student s) {
		//reverse sorting on string
		return s.name.compareToIgnoreCase(this.name);
	}
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		Student s1 = new Student(24,"Rohit sawarkar",23,12); 
		Student s2 = new Student(21,"Akshat rohini",16,11); 
		Student s3 = new Student(25,"Jash kapsi",18,10); 
		Student s4 = new Student(20,"Sahil sharma",15,8); 
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		System.out.println(list);
		Collections.sort(list);
		System.out.println();
		System.out.println("After sorting elements by name");
		System.out.println(list);
		System.out.println("After sorting elements by age");
		Collections.sort(list, new AgeComparator());
		System.out.println(list);
		
	}

}
