package com.wissen.enums.example;

public enum Department {
	
	TECHNOLOGY("tech"),
	FINANCE("finan"),
	COMPILANCE("compliance"),
	HR ("hR");
	
	private String dept;

	Department(String dept) {
		this.dept = dept;
	}
	
	public String getName() {
		return this.dept;
	}
	
	public static Department getDepartmentByName(String name) {
		for(Department dep :  Department.values()) {
			if(dep.getName().equalsIgnoreCase(name)) {
				return dep;
			}
		}
		return null;
	}
}
