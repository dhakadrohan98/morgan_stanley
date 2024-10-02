package com.wissen.hashcode.equals.method;

import java.util.Objects;

public class Student2 {
	
	private int id;
	private String name;

	public Student2(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		//if current object and obj are equal, return true
		if(this == obj) return true;
		//if obj is null or class of obj is not equal with current class, return false;
		if(obj == null || this.getClass() != obj.getClass()) return false;
		//first type cast obj into Student class & then checks fields(id, name) equality, if equals then return true otherwise false
		Student2 student = (Student2) obj;
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
		Student2 s1 = new Student2(1, "Ankur");
		Student2 s2 = new Student2(1, "Ankur");
		Student2 s3 = new Student2(1, "Ritesh");
		
		//two objects are equals or not
		System.out.println(s1.equals(s2));
		//two objects are equals or not
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
