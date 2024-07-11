package com.wissen.immutableclass;

import java.util.*;

public class StudentClassImpl {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Maths");
		list.add("Physics");
		list.add("Chemistry");
		System.out.println("Intialized subject list from client program");
		System.out.println(list);
		
		ImmutableStudent s1 = new ImmutableStudent(1, "Rohan", list);
		
		List<String> subjects = s1.getSubjects();
		subjects.add(1, "Astro physics");
		System.out.println("Modified subject list from client program");
		System.out.println(subjects);
		
		System.out.println("Subject list from Immutable class");
		System.out.println(s1.getSubjects());
	}

}
