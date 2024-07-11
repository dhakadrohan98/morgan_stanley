package com.wisse.core.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	String name;
	int age;
	
	public Employee(String name, int age) {
		System.out.println("Employee() constructor is called");
		this.name = name;
		this.age = age;
	}
}

public class SerializationDeserializationExample {

	public static void main(String[] args) {
		Employee emp = new Employee("Rohan", 25);
		String fileName = "employee.ser";
		//serialization
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(emp);
			System.out.println("Employee object serialized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//deserialization
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			Employee emp1 = (Employee) in.readObject();
			System.out.println("Employee Object deserialized successfully. emp1.name: " + emp1.name + " emp1.age: " + emp1.age);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
