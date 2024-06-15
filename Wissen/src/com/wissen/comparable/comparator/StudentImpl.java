package com.wissen.comparable.comparator;

import java.util.*;

public class StudentImpl {

	public static void main(String[] args) {
		Student s1 = new Student(11, "Zakhir", "rakhit@gmail.com", 98);
		Student s2 = new Student(12, "Shubham", "shivam@gmail.com", 980);
		Student s3 = new Student(13, "Rahul", "rahul@gmail.com", 8999);
		
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		System.out.println(list);
		System.out.println("****************");
		Collections.sort(list);
		System.out.println(list);
		
	}
}
