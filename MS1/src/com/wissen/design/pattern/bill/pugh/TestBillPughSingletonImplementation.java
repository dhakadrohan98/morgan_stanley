package com.wissen.design.pattern.bill.pugh;

public class TestBillPughSingletonImplementation {

	public static void main(String[] args) {
		A obj1 = A.getInstance();
		A obj2 = A.getInstance();
		A obj3 = A.getInstance();
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

	}

}
