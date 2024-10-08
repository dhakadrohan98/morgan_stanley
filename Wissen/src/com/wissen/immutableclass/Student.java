package com.wissen.immutableclass;

import java.util.*;

public final class Student {
	private final int id;
	private final String name;
	private final List<String> subjects;
	
	public Student(int id, String name, List<String> subjects) {
		this.id = id;
		this.name = name;
		//create another list as copyList & copy incoming list objects into copyList and assign 
		//copyList to  this.subjects list
		List<String> copyList = new ArrayList<>(subjects);
//		for(String subject: subjects) {
//			copyList.add(subject);
//		}
		this.subjects = copyList;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	//create another list as copyList & copy current list(subjects) objects into copyList and 
	//return this copy as deep copy of list
	public List<String> getSubjects() {
		List<String> copyList = new ArrayList<>(this.subjects);
//		for(String subject: this.subjects) {
//			copyList.add(subject);
//		}
		return copyList;
	}
}
