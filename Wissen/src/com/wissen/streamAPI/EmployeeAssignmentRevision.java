package com.wissen.streamAPI;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee1 {
	
	String name;
	int age;
	int salary;
	String designation;
	String gender;
	String department;
	
	public Employee1(String name, int age, int salary, String designation, String gender, String department) {
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
public class EmployeeAssignmentRevision {

	public static void main(String[] args) {
		Employee1 emp1 = new Employee1("Rakesh", 19, 20000, "Trainee analyst", "male", "development");
		Employee1 emp2 = new Employee1("Shivansh", 21, 23000, "Asscoiate Software Developer", "male", "development");
		Employee1 emp3 = new Employee1("Dhruv", 20, 20000, "Trainee analyst", "male", "development");
		Employee1 emp4 = new Employee1("Sikha", 24, 25000, "Software Developer", "female", "development");
		Employee1 emp5 = new Employee1("Aarushi", 23, 24000, "Software Developer", "female", "development");
		Employee1 emp6 = new Employee1("Aishwarya", 27, 28000, "Software Developer", "female", "development");
		Employee1 emp7 = new Employee1("Amrita", 26, 22000, "Suppport Engineer", "female", "IT");
		Employee1 emp8 = new Employee1("Akhilesh", 29, 23000, "Suppport Engineer", "male", "IT");
		Employee1 emp9 = new Employee1("Akshata", 18, 20000, "Trainee analyst", "female", "development");
		Employee1 emp10 = new Employee1("Aakash", 28, 33000, "Software Developer", "male", "development");
		
		List<Employee1> list = new ArrayList<>();
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
		
		System.out.println(list);
		System.out.println("------------------------------");
		
		//1. Display Employees having age greater than or equal to 22
		System.out.println("1. Display Employees having age greater than or equal to 22");
		Map<Boolean, List<Employee1>> collect1 = list
				.stream()
				.collect(Collectors.partitioningBy(e -> e.age >= 22));
		
		System.out.println(collect1);
		System.out.println("------------------------------");
		
		System.out.println("2. Count total no. of Employees having age greater than or equal to 22");
		Map<Boolean, Long> collect2 = list.stream()
		.collect(Collectors.partitioningBy(e -> e.age >= 22, Collectors.counting()));

		System.out.println(collect2);
		System.out.println("------------------------------");
		
		System.out.println("3. Group employees designation wise");
		Map<String, List<Employee1>> collect3 = 
				list
				.stream()
				.collect(Collectors.groupingBy(e -> e.designation));
		System.out.println(collect3);
		System.out.println("------------------------------");
		
		System.out.println("4. Count employees designation wise");
		Map<String, Long> collect4 = list
		.stream()
		.collect(Collectors.groupingBy(e -> e.designation, Collectors.counting()));
		System.out.println(collect4);
		System.out.println("------------------------------");
		
		System.out.println("5. Total salaries for each designation paid by company");
		Map<String, Integer> collect5 = list
		.stream()
		.collect(Collectors.groupingBy(e -> e.designation, Collectors.summingInt(e -> e.salary)));
		System.out.println(collect5);
		System.out.println("------------------------------");
		
		System.out.println("6. Top 3 senior employees");
		List<Employee1> collect6 = list
		.stream()
		.sorted((e1, e2) -> e2.age - e1.age)
		.limit(3)
		.collect(Collectors.toList());
		System.out.println(collect6);
		System.out.println("------------------------------");
		
		System.out.println("7. Most junior employee");
		Employee1 juniorEmployee = list
				.stream()
				.min((e1,e2) -> e1.age - e2.age)
				.orElse(null);
		System.out.println(juniorEmployee);
		System.out.println("------------------------------");
		
		System.out.println("8. Highest salary paid employee");
		Employee1 highestSalaryPaidEmployee = list
		.stream()
		.max((e1, e2) -> e1.salary - e2.salary).
		orElse(null);
		
		System.out.println(highestSalaryPaidEmployee);
		

	}

}
