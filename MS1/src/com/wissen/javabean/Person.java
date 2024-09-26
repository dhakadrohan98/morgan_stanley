package com.wissen.javabean;

import java.io.Serializable;

//JavaBean class

public class Person implements Serializable {
    private String name;
    private int age;

    // No-arg constructor
    public Person() {}

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}

