package com.wissen.interfaces.inheritance;

interface animal {
	void eat();
}

interface Mammal extends animal {
	void walk();
}

public class Human implements Mammal {

	@Override
	public void eat() {
		System.out.println("human is eating");
	}

	@Override
	public void walk() {
		System.out.println("human is walking");
	}
	
	public static void main(String[] args) {
		Human human = new Human();
		human.eat();
		human.walk();
				
	}
}


