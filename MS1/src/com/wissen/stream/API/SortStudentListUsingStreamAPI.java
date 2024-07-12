package com.wissen.stream.API;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wissen.sorting.Student;

public class SortStudentListUsingStreamAPI {

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
		
		list = list.stream().sorted((o1,o2) -> o1.name.compareTo(o2.name)).collect(Collectors.toList());
		System.out.println(list);
		
		}

}
