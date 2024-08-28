package com.wissen.staticmethod.overriding;


class Base {
    public static void display() {
        System.out.println("Static method from Base");
    }
}
class Derived extends Base {
    public static void display() {
        System.out.println("Static method from Derived");
    }
}

public class StaticMethodOverridingExample2 {
	
	//instance variable
	int y = 0;

	public static void main(String[] args) {
		Base obj1 = new Derived();
        obj1.display(); // Calls the Derived class method

	}

}
