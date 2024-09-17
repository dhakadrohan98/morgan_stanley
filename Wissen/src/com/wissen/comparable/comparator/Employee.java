package com.wissen.comparable.comparator;

import java.util.*;


//Comparator doesn't affect the original class
//Q. Sort the employee List based on their names if names are same then sort the basis on their salaries.
class EmployeeComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee e1, Employee e2) {
		if(e2.name.equals(e2.name)) {
			return e2.salary - e1.salary;
		}
		return e2.name.compareToIgnoreCase(e1.name);
	}
}

public class Employee {
	
	int id;
	String name;
	String designation;
	int salary;
	
	public Employee(int id, String name, String designation, int salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp1 = new Employee(23,"Rakesh", "tester", 20000);
		Employee emp2 = new Employee(21,"Aadi", "developer", 20000);
		Employee emp3 = new Employee(20,"Alexander", "developer", 20000);
		Employee emp4 = new Employee(29,"Arnav", "developer", 20000);
		Employee emp5 = new Employee(26,"Andrew", "manager", 20000);
		Employee emp6 = new Employee(32,"David", "developer", 20000);
		Employee emp7 = new Employee(30,"Dhruv", "HR", 20000);
		Employee emp8 = new Employee(25,"Rakesh", "QA Lead", 25000);
			
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
		Collections.sort(list, new EmployeeComparator());
		System.out.println("List after sorting");
		System.out.println(list);
	}

}
