package com.wissen.design.pattern;

class Single {
	private static Single obj = null;
	
	public static Single getInstance() {
		if(obj == null) {
			obj = new Single();
		}
		return obj;
	}
}
public class SingletonExample {

	public static void main(String[] args) {
		System.out.println("hi");

	}

}
