package com.wissen.comparable.comparator;

public class Student implements Comparable<Student> {
	
	int id;
	String name;
	String email;
	long phone;
	
	public Student(int id, String name, String email, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public int compareTo(Student s) {
		return this.name.compareTo(s.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
}