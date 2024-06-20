package com.wissen.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

class Employee {

	String name;
	int age;
	int salary;
	String designation;
	String gender;
	String department;

	public Employee(String name, int age, int salary, String designation, String gender, String department) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.gender = gender;
		this.department = department;
	}

	@Override
	public String toString() {
		return "(" + name + ", age=" + age + ", salary=" + salary + ", designation=" + designation + ", gender="
				+ gender + ", department=" + department + ")";
	}
}

public class AssignmentStreamAPI {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Rakesh", 19, 20000, "Trainee analyst", "male", "development");
		Employee emp2 = new Employee("Shivansh", 21, 23000, "Asscoiate Software Developer", "male", "development");
		Employee emp3 = new Employee("Dhruv", 20, 20000, "Trainee analyst", "male", "development");
		Employee emp4 = new Employee("Sikha", 24, 25000, "Software Developer", "female", "development");
		Employee emp5 = new Employee("Aarushi", 23, 24000, "Software Developer", "female", "development");
		Employee emp6 = new Employee("Aishwarya", 27, 28000, "Software Developer", "female", "development");
		Employee emp7 = new Employee("Amrita", 26, 22000, "Suppport Engineer", "female", "IT");
		Employee emp8 = new Employee("Akhilesh", 29, 23000, "Suppport Engineer", "male", "IT");
		Employee emp9 = new Employee("Akshata", 19, 20000, "Trainee analyst", "female", "development");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		list.add(emp6);
		list.add(emp7);
		list.add(emp8);
		list.add(emp9);
		
		System.out.println(list);
		System.out.println("------------------------------");
		
		System.out.println("Total number of employees");
		Long total = list.stream().collect(Collectors.counting());
		System.out.println(total);
		System.out.println("------------------------------");
		
		System.out.println("Top 3 senior employees");
		List<Employee> top3Employees = list.stream().sorted((o1, o2) -> Integer.compare(o2.age, o1.age)).limit(3).collect(Collectors.toList());
		System.out.println(top3Employees);
		System.out.println("------------------------------");
		
		System.out.println("Most Junior Employee");
		List<Employee> mostJuniorEmployee = list.stream().sorted((e1,e2)-> Integer.compare(e1.age, e2.age)).limit(1).collect(Collectors.toList());
		Employee junior = mostJuniorEmployee.get(0);
		mostJuniorEmployee.remove(0);
		//there are more than one most junior (at the same age level)
		for(int i=0; i<list.size(); i++) {
			if(junior.age == list.get(i).age) {
				mostJuniorEmployee.add(list.get(i));
			}
		}
		System.out.println(mostJuniorEmployee);
		System.out.println("----------------------");
		
		System.out.println("Highest salray paid employee");
		int maxSalary = 0;
		List<Employee> maxSalaryEmployee = list.stream().sorted((e1,e2)-> Integer.compare(e2.salary, e1.salary)).limit(1).collect(Collectors.toList());
		System.out.println(maxSalaryEmployee.get(0));
		System.out.println("----------------------");
		
		System.out.println("Total number of males & females");
		Map<String, Long> maleFemaleCount = list.stream().collect(Collectors.groupingBy(e->e.gender, Collectors.counting()));
		System.out.println(maleFemaleCount);
		System.out.println("--------------");
		
		System.out.println("Total expense department wise");
		Map<String, Integer> totalExpense = list.stream().collect(Collectors.groupingBy(e-> e.department, Collectors.summingInt(e->e.salary)));
		System.out.println(totalExpense);
		
		
	}

}
