package com.wissen.StreamAPI;

import java.util.*;
import java.util.stream.*;

class Emp {
	String name;
	int age;
	int salary;
	String designation;

	public Emp(String n, int a, int s, String d) {
		name = n;
		age = a;
		salary = s;
		designation = d;
	}

	@Override
	public String toString() {
		return "(" + name + ", " + age + ", " + salary + ", " + designation + ")";
	}
}

public class StreamDemo3 {

	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("Rakesh", 32, 40000, "Programmer"));
		list.add(new Emp("Suresh", 22, 20000, "Programmer"));
		list.add(new Emp("Mahesh", 36, 30000, "Tester"));
		list.add(new Emp("Jignesh", 27, 20000, "Tester"));
		list.add(new Emp("Mangesh", 51, 90000, "Manager"));
		list.add(new Emp("Rajesh", 32, 40000, "Tester"));
		list.add(new Emp("Ramesh", 22, 25000, "Tester"));
		list.add(new Emp("Dinesh", 38, 70000, "Programmer"));
		list.add(new Emp("Lokesh", 30, 40000, "Programmer"));
		list.add(new Emp("Ganesh", 31, 50000, "Programmer"));
		list.add(new Emp("Mukesh", 39, 80000, "Manager"));
		list.add(new Emp("Mahantesh", 42, 85000, "Manager"));
		list.add(new Emp("Brijesh", 26, 20000, "Tester"));
		list.add(new Emp("Veeresh", 22, 30000, "Programmer"));

		//Display employees whose age is greater than or equal to 30
		System.out.println("Display employees whose age is greater than or equal to 30");
		Map<Boolean, List<Emp>> m1 = list.stream().collect(Collectors.partitioningBy(e -> e.age >= 30));
		System.out.println(m1);
		System.out.println("--------------------------------------");

		//Display employees count whose age is greater than or equal to 30
		System.out.println("Display employees count whose age is greater than or equal to 30");
		Map<Boolean, Long> m2 = list.stream()
				.collect(Collectors.partitioningBy(e -> e.age >= 30, Collectors.counting()));
		System.out.println(m2);
		System.out.println("--------------------------------------");

		//Group employees designation wise
		System.out.println("Group employees designation wise");
		Map<String, List<Emp>> m3 = list.stream().collect(Collectors.groupingBy(e -> e.designation));
		System.out.println(m3);
		System.out.println("--------------------------------------");

		//count Total no. of employees designation wise
		System.out.println("");
		System.out.println("count Total no. of employees designation wise:");
		Map<String, Long> m4 = list.stream().collect(Collectors.groupingBy(e -> e.designation, Collectors.counting()));
		System.out.println(m4);
		System.out.println("--------------------------------------");

		//Calculate total salary of each designation paid by company
		System.out.println("Calculate total salary of each designation paid by company");
		Map<String, Integer> m5 = list.stream().collect(Collectors.groupingBy(e -> e.designation, Collectors.summingInt(e-> e.salary)));
		System.out.println(m5);
		System.out.println("--------------------------------------");
	}

}
