package com.wissen.comparable.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Comparable affects the original class
public class EmployeeComparable implements Comparable<EmployeeComparable> {

	int id;
	String name;
	String designation;
	int salary;
	
	public EmployeeComparable(int id, String name, String designation, int salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	@Override
	public int compareTo(EmployeeComparable e) {
		return this.name.compareToIgnoreCase(e.name);
	}
	
	@Override
	public String toString() {
		return "EmployeeComparable [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ "]";
	}

	public static void main(String[] args) {
		EmployeeComparable emp1 = new EmployeeComparable(23,"Rakesh", "tester", 20000);
		EmployeeComparable emp2 = new EmployeeComparable(21,"Aadi", "developer", 20000);
		EmployeeComparable emp3 = new EmployeeComparable(20,"Alexander", "developer", 20000);
		EmployeeComparable emp4 = new EmployeeComparable(29,"Arnav", "developer", 20000);
		EmployeeComparable emp5 = new EmployeeComparable(26,"Andrew", "manager", 20000);
		EmployeeComparable emp6 = new EmployeeComparable(32,"David", "developer", 20000);
		EmployeeComparable emp7 = new EmployeeComparable(30,"Dhruv", "HR", 20000);
		EmployeeComparable emp8 = new EmployeeComparable(25,"Rakesh", "QA Lead", 25000);
		
		List<EmployeeComparable> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		list.add(emp6);
		list.add(emp7);
		list.add(emp8);
		
		System.out.println("List before sorting");
		System.out.println(list);
		Collections.sort(list);
		System.out.println("List after sorting");
		System.out.println(list);
	}
	
}
