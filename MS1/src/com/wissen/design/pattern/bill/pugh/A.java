package com.wissen.design.pattern.bill.pugh;

public class A {

	private A() {
	}
	/**
	 *  The inner class does not get loaded at the time of class A loading, only
		when someone calls getInstance() method, it gets loaded and creates
		the Singleton instance
	 */
	private static class InnerA {
		private static final A instance = new A();
	}

	public static A getInstance() {
		return InnerA.instance;
	}
	
}
