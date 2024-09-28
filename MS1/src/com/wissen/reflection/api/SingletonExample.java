package com.wissen.reflection.api;

public class SingletonExample {
	private SingletonExample() {}
	//can be accessed outside the world, Eager initialization
	public static final SingletonExample instance = new SingletonExample();
	
	
	/**
	 *  prevent Singleton from Reflection, one simple solution is to
		throw an exception from the private constructor, so when Reflection
		tries to invoke private constructor, there will be an error
	 */
	
//	private SingletonExample() {
//		if(SingletonExample.instance != null) {
//			throw new InstantiationError("This object creation is not allowed");
//		}
//	}
}
