package com.wissen.oops;

//Encapsulated class 
class Person {
    // Private fields
    private String name;
    private int age;

    // Public getter for name
    public String getName() {
        return name;
    }

    // Public setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter for age
    public int getAge() {
        return age;
    }

    // Public setter for age
    public void setAge(int age) {
        if (age > 0) { // Adding a simple validation
            this.age = age;
        }
    }
}

public class EncapsulationExample {

	public static void main(String[] args) {
		// Creating an instance of Person
        Person person = new Person();
        
        // Setting values using setters
        person.setName("John");
        person.setAge(30);
        
        // Getting values using getters
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
	}
}
