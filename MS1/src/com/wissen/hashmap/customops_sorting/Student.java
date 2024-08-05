package com.wissen.hashmap.customops_sorting;

import java.util.Objects;

public class Student {
	
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		//if current and obj are not equal, return false
		if(this == obj) return true;
		//if obj is null or class of obj is not equal with current class, return false;
		if(obj == null || getClass() != obj.getClass()) return false;
		//first type cast obj into Student class & then checks fields(id, name) equality, if equals then return true otherwise false
		Student student = (Student) obj;
		if(this.id == student.id && this.name.equalsIgnoreCase(student.name)) {
			return true;
		} 
		return false;
	}
	
	@Override
	public int hashCode() {
		//Objects.hash(field1, field2, field3) to generate hash code.
		return Objects.hash(id, name);
	}
	
	public static void main(String[] args) {
		Student s1 = new Student(1, "Ankur");
		Student s2 = new Student(1, "Ankur");
		//two objects are equals or not
		System.out.println(s1.equals(s2));
		
		Student s3 = new Student(1, "Ritesh");
		System.out.println(s2.equals(s3));
		
		//check for hashCode() equality
		int s1HashCode = s1.hashCode();
		int s2HashCode = s2.hashCode();
		int s3HashCode = s3.hashCode();
		System.out.println(s1HashCode);
		System.out.println(s2HashCode);
		System.out.println(s3HashCode);
		
	}

}
