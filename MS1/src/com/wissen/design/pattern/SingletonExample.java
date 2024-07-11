package com.wissen.design.pattern;

class Single {
	private static Single obj = null;
	
	private Single() {}
	
	public static Single getInstance() {
		if(obj == null) {
			obj = new Single();
		}
		return obj;
	}
}
public class SingletonExample {

	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance();
		Single obj3 = Single.getInstance();
		Single obj4 = Single.getInstance();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);
		
		

	}

}
