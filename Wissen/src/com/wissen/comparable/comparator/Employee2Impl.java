package com.wissen.comparable.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee2 implements Comparable<Employee2> {
	
	public int id;
	public String name;
	
	public Employee2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Employee2 obj) {
		//if two employee name are same then sort it on the basis of their id
		if(this.name.equalsIgnoreCase(obj.name)) {
			return this.id - obj.id;
		}
		return this.name.compareTo(obj.name);
	}

	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + "]";
	}
	
}


public class Employee2Impl {
	
	public static void main(String[] args) {
		Employee2 emp1 = new Employee2(1, "rohan");
		Employee2 emp2 = new Employee2(2, "rohan");
		Employee2 emp3 = new Employee2(1, "ashish");
		
		List<Employee2> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
	}
}
