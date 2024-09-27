package com.wissen.copyconstructor;

//here we have used copy constructor to perform deep copy
class Company implements Cloneable {
	private String name;

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

public class Employee implements Cloneable {
	
	private String name;
	private int age;
	private Company company;
	
	public Employee(String name, int age, Company company) {
		this.name = name;
		this.age = age;
		this.company = company;
	}
	
	//Copy constructor
	public Employee(Employee emp) {
		this.name = emp.getName();
		this.age = emp.getAge();
		Company newCompanyObj = new Company(emp.getCompany().getName());
		this.company = newCompanyObj;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}




	public static void main(String[] args) throws CloneNotSupportedException {
		Company c1 = new Company("Facebook");
		Employee e1 = new Employee("Mike", 10, c1);
		System.out.println("Employee 1, company name : "+ e1.getCompany().getName());
		
		//invoking copy constructor
		Employee e2 = new Employee(e1);
		System.out.println("Employee 2, company name : "+ e2.getCompany().getName());
		e2.getCompany().setName("Apple");
		System.out.println("----------------------------------------------------------");
		System.out.println("Employee 1, company name : "+ e1.getCompany().getName());
		System.out.println("Employee 2, company name : "+ e2.getCompany().getName());
		

	}

}
