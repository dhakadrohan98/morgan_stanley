package com.wissen.generics;

class Test<T> {
	private T obj;
	
	public Test(T obj) {
		this.obj = obj;
	}
	
	public T getObject() {
		return this.obj;
	}
}

public class GenericDemo {
	public static void main(String[] args) {
		Test<String> t1 = new Test<>("Passing String to generic type");
		System.out.println(t1.getObject());
		
		Test<Integer> t2 = new Test<>(13);
		System.out.println(t2.getObject());
	}
}
