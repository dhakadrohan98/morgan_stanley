package com.wissen.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

public class StreamAPIAssignmentsCustomClass {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Rakesh", 19, 20000, "Trainee analyst", "male", "development");
		Employee emp2 = new Employee("Shivansh", 21, 23000, "Software Developer", "male", "development");
		Employee emp3 = new Employee("Dhruv", 20, 20000, "Trainee analyst", "male", "development");
		Employee emp4 = new Employee("Sikha", 24, 25000, "Software Developer", "female", "development");
		Employee emp5 = new Employee("Aarushi", 23, 24000, "Software Developer", "female", "development");
		Employee emp6 = new Employee("Aishwarya", 27, 28000, "Software Developer", "female", "development");
		Employee emp7 = new Employee("Amrita", 26, 22000, "Suppport Engineer", "female", "IT");
		Employee emp8 = new Employee("Akhilesh", 29, 23000, "Suppport Engineer", "male", "IT");
		Employee emp9 = new Employee("Akshata", 19, 20000, "Trainee analyst", "female", "development");
		Employee emp10 = new Employee("Aakash", 28, 50000, "Software Developer", "male", "development");
		Employee emp11 = new Employee("Daksh", 30, 60000, "Manager", "male", "development");
		
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
		list.add(emp10);
		list.add(emp11);
		
		System.out.println("------------------------------");
		
		System.out.println("Display Employees having age greater than or equal to 22");
		Map<Boolean, List<Employee>> collect = list.stream().collect(Collectors.partitioningBy(e -> e.age >= 22));
		System.out.println(collect);
		System.out.println("------------------------------");
		
		System.out.println("count total no. of Employees having age greater than or equal to 22");
		Map<Boolean, Long> collect1 = list.stream().collect(Collectors.partitioningBy(e -> e.age >= 22, Collectors.counting()));
		System.out.println(collect1);
		System.out.println("------------------------------");
		
		System.out.println("Group employees designation wise");
		Map<String, List<Employee>> collect2 = list.stream().collect(Collectors.groupingBy(e -> e.designation));
		System.out.println(collect2);
		System.out.println("------------------------------");
		
		System.out.println("Count employees designation wise");
		Map<String, Long> collect3 = list.stream().collect(Collectors.groupingBy(e -> e.designation, Collectors.counting()));
		System.out.println(collect3);
		System.out.println("------------------------------");
		
		System.out.println("Total salaries for each designation paid by company");
		Map<String, Long> collect4 = list.stream().collect(Collectors.groupingBy(e -> e.designation, Collectors.summingLong(e -> e.salary)));
		System.out.println(collect4);
		System.out.println("------------------------------");
		
		System.out.println("Total number of employees");
		Long collect5 = list.stream().collect(Collectors.counting());
		System.out.println(collect5);
		System.out.println("------------------------------");
		
		System.out.println("Top 3 senior employees");
		List<Employee> emp = list.stream().sorted((o1, o2) -> o2.age - o1.age).limit(3).collect(Collectors.toList());
		System.out.println(emp);
		System.out.println("------------------------------");
		
		System.out.println("Most junior employee");
		Employee juniorEmp = list.stream().min((o1, o2) -> o1.age - o2.age).orElse(null);
		System.out.println(juniorEmp);
		System.out.println("------------------------------");
		
		System.out.println("highest salary paid employee");
		Employee highestSalPaidEmp = list.stream().max((o1, o2) -> o1.salary - o2.salary).orElse(null);
		System.out.println(highestSalPaidEmp);
		System.out.println("------------------------------");
		
		System.out.println("Total number of males & females");
		Map<String, Long> collect6 = list.stream().collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));
		System.out.println(collect6);
		
		
	}
}
