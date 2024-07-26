package com.wissen.stream.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class EmployeeProblems {

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
		
		System.out.println("1.Display Employees having age greater than or equal to 22");
		Map<Boolean, List<Employee>> collect = list.stream().collect(Collectors.partitioningBy(e -> e.age >= 22));
		System.out.println(collect);
		System.out.println("------------------------------");
		
		System.out.println("2. Count total no. of Employees having age greater than or equal to 22");
		Map<Boolean, Long> collect2= list.stream().collect(Collectors.partitioningBy(e -> e.age >= 22, Collectors.counting()));
		System.out.println(collect2);
		System.out.println("------------------------------");
		
		System.out.println("3. Group employees designation wise");
		Map<String, List<Employee>> collect3 = list.stream().collect(Collectors.groupingBy(e -> e.designation));
		System.out.println(collect3);
		System.out.println("------------------------------");
		
		System.out.println("4. Count employees designation wise");
		Map<String, Long> collect4 = list.stream().collect(Collectors.groupingBy(e -> e.designation, Collectors.counting()));
		System.out.println(collect4);
		System.out.println("------------------------------");
		
		System.out.println("5. Total salaries for each designation paid by company");
		Map<String, Integer> collect5 = list.stream().collect(Collectors.groupingBy(e -> e.designation, Collectors.summingInt(e -> e.salary)));
		System.out.println(collect5);
		System.out.println("------------------------------");
		
		System.out.println("6. Total number of employees");
		Long collect6 = list.stream().collect(Collectors.counting());
		System.out.println(collect6);
		System.out.println("------------------------------");
		
		System.out.println("7. Top 3 senior employees");
		List<Employee> collect7 = list.stream().sorted((e1, e2) -> e2.age - e1.age).limit(3).collect(Collectors.toList());
		System.out.println(collect7);
		System.out.println("------------------------------");
		
		System.out.println("8. Most junior employees");
		Employee mostJuniorEmployee = list.stream().min((e1, e2) -> e1.age - e2.age).orElse(null);
		System.out.println(mostJuniorEmployee);
		System.out.println("------------------------------");
		
		System.out.println("9. Highest salary paid employee");
		Employee highestSalaryPaidEmp = list.stream().max((e1,e2) -> e1.salary - e2.salary).orElse(null);
		System.out.println(highestSalaryPaidEmp);
		System.out.println("------------------------------");
		
		System.out.println("10. Total number of males & females");
		Map<String, Long> collect8 = list.stream().collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));
		System.out.println(collect8);
	}
}
