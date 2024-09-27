package com.wissen.init.block;

/**
 * Compiler copies all the code of instance inializer block into the constructor after 
 * first statement super().
*/

class InitBlock {
	//instance inializer block
	{
		System.out.println("Init block is called before constructor");
	}
	
	InitBlock() {
		System.out.println("InitBlock class constructor is called");
	}
	
	//instance inializer block
	{
		System.out.println("Init block is called after constructor");
	}
}

class Child extends InitBlock {
	//instance inializer block
	{
		System.out.println("Child Init block is called before constructor");
	}
	
	Child() {
		System.out.println("Child class constructor is called");
	}
	
	//instance inializer block
	{
		System.out.println("Child Init block is called after constructor");
	}
}

public class TestInit {
	
	public static void main(String[] args) {
		new Child();
	}
}
