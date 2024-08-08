package com.wissen.oops;

interface InterfaceA {
    default void display() {
        System.out.println("InterfaceA display");
    }
}

interface InterfaceB {
    default void display() {
        System.out.println("InterfaceB display");
    }
}

public class TwoInterfaceSameDefaultMethod implements InterfaceA, InterfaceB {

	@Override
	public void display() {
		InterfaceA.super.display();
		InterfaceB.super.display();
	}
	
	public static void main(String[] args) {
		TwoInterfaceSameDefaultMethod obj = new TwoInterfaceSameDefaultMethod();
		obj.display();
	}
	
}


//TwoInterfaceSameDefaultMethod