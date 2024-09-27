package com.wissen.extenalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

//We decide what we want to store in a stream
//Change default's behaviour of serlialization & deserlialization
public class Employee implements Externalizable {
	
	private String name;
	private int age;
	private transient int salary;
	private String companyName;
	
	public Employee() {
		System.out.println("No-arg constructor of Employee class");
	}
	
	public Employee(String name, int age, int salary, String companyName) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		out.writeInt(salary);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
		salary = in.readInt();
	}
	
}
