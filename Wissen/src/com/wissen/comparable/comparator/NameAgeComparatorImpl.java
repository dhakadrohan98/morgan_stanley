package com.wissen.comparable.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * compare a list of Employees based on
	name and age such that if name of the employee is same
	then sorting should be based on age
 */
class Employee1 {
	
	int id;
	String name;
	String designation;
	int salary;
	int age;
	
	public Employee1(int id, String name, String designation, int salary, int age) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", age=" + age + "]";
	}
}

class NameAgeComparator implements Comparator<Employee1> {
	
	Object obj = new Object();
	
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		int comp = e1.name.compareToIgnoreCase(e2.name);
		if(comp == 0) { //two names are equal, then compare on the basis of age
			comp = e1.age - e2.age;
		}
		return comp;
	}

}

public class NameAgeComparatorImpl {

	public static void main(String[] args) {
		List<Employee1> list = new ArrayList<>();
		Employee1 emp1 = new Employee1(23,"Arnav", "tester", 20000, 27);
		Employee1 emp2 = new Employee1(21,"Aadi", "developer", 20000, 20);
		Employee1 emp3 = new Employee1(20,"Alexander", "developer", 20000, 30);
		Employee1 emp4 = new Employee1(29,"Arnav", "developer", 20000, 25);
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		Collections.sort(list, new NameAgeComparator());
		System.out.println(list);
		System.out.println(Runtime.getRuntime());
	}

}
