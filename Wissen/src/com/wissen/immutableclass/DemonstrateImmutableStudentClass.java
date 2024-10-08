package com.wissen.immutableclass;

import java.util.*;

public class DemonstrateImmutableStudentClass {

	public static void main(String[] args) {
		List<String> subjects = new ArrayList<String>();
		subjects.add("maths");
		subjects.add("physics");
		subjects.add("chemistry");
		int id = 1;
		String name = "Sahani";
		
		Student std = new Student(id, name, subjects);
		System.out.println(std.getId());
		System.out.println(std.getName());
		System.out.println(std.getSubjects());
		
		subjects.add(1, "Astro physics");
		System.out.println(std.getSubjects());
		
		std.getSubjects().add(2, "Organic chemistry");
		System.out.println(std.getSubjects());
		
	}

}
