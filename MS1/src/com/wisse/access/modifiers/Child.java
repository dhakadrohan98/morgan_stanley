package com.wisse.access.modifiers;

//same package sub class
public class Child extends Parent {

	public static void main(String[] args) {
		Parent p  = new Parent();
		String name2 = p.name;
	}

}
