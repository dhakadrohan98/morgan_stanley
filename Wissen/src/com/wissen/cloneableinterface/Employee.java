package com.wissen.cloneableinterface;

/*
 * Clone method is called on primitive types only, if it is called on Object type, then shallow 
 * copy will be peformed through clone() method
 * */
public class Employee implements Cloneable {
	
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee("Mike", 10);
		System.out.println("Employee 1, name : "+ e1.getName());
		Employee e2 = (Employee) e1.clone();
		e2.setName("Kane");
		System.out.println("Employee 1, name : "+ e1.getName());
		System.out.println("Employee 2, name : "+ e2.getName());
		

	}

}
