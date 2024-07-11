package com.wissen.immutableclass;

import java.util.*;

public final class ImmutableStudent {
	
	private final int id;
	private final String name;
	private final List<String> subjects;
	
	public ImmutableStudent(int id, String name, List<String> subjects) {
		this.id = id;
		this.name = name;
		this.subjects = new ArrayList<>(subjects);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getSubjects() {
		return new ArrayList<>(subjects);
	}

	@Override
	public String toString() {
		return "ImmutableStudent [id=" + id + ", name=" + name + ", subjects=" + subjects + "]";
	}
}
