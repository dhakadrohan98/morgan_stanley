package com.wissen.garbage.collection;

/*
 * Suppose you go for the internship at Wissen technology, and you were told to write a program to count 
 * the number of employees working in the company(excluding interns). To make this program, you have to 
 * use the concept of a garbage collector. 
 */

/*
 * Write a program to create a class called Employee having the following data members. 

	1. An ID for storing unique id allocated to every employee. 
	2. Name of employee. 
	3. age of an employee.
	
	Also, provide the following methods:
	
	A parameterized constructor to initialize name and age. The ID should be initialized in this constructor.
	A method show() to display ID, name, and age.
	A method showNextId() to display the ID of the next employee.
*/

public class Employee {

	private int id;
	private String name;
	private int age;

	// nextId will be shared among all objects as common variable
	private static int nextId = 1;

	public Employee(String name, int age) {
		this.id = nextId;
		this.name = name;
		this.age = age;
		this.nextId++;
	}

	public void show() {
		System.out.println("Id " + id + " Name " + name + " Age " + age);
	}

	public void showNextId() {
		System.out.println("Next id of the employee will be " + nextId);
	}

	@Override
	public void finalize() {
		// In this case, gc will call finalize() 2 times for 2 objects.
		nextId -= 1;
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee("wt41", 23);
		Employee emp2 = new Employee("wt42", 25);
		Employee emp3 = new Employee("wt43", 21);
		emp1.show();
		emp2.show();
		emp3.show();
		emp1.showNextId();
		emp2.showNextId();
		emp3.showNextId();

		{
			// It is sub block to keep all interns of Wissen technology.
			Employee emp4 = new Employee("wt44", 26);
			emp4.show();
			emp4.showNextId();
			Employee emp5 = new Employee("wt45", 27);
			emp5.show();
			emp5.showNextId();
			emp4 = null;
			emp5 = null;
			//requesting JVM to run Garbage Collector
			System.gc();
			//runFinalization() -> Runtime.getRuntime().runFinalization();
			System.runFinalization();
		}
		// After countering this brace, emp4 & emp5 will be removed
		System.out.print("get the next id details through emp1 object. ");
		// it should next id as 4 because emp4 & emp5 doesn't exist
		emp1.showNextId();

	}

}
