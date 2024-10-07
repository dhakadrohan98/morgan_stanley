package com.wissen.hashcode.equals.method;

import java.util.Objects;

public class Student<> {
	int id;
	String name;
	int age;
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		//generate hash code based on id & name
		return Objects.hash(id, name.toLowerCase());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Student student = (Student) obj;
		//if id of two students are equal then check the equality basis on the name
		if(this.id == student.id) {
			return this.name.equalsIgnoreCase(student.name);
		}
		return this.id == student.id;
	}
	
	
}
