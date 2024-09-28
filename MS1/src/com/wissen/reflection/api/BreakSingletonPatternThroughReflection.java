package com.wissen.reflection.api;

import java.lang.reflect.Constructor;

public class BreakSingletonPatternThroughReflection {

	public static void main(String[] args) {
		SingletonExample instance1 = SingletonExample.instance;
		SingletonExample instance2 = null;
		Constructor[] constructors = SingletonExample.class.getDeclaredConstructors();
		
		for(Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				instance2 = (SingletonExample) constructor.newInstance();
				break;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Instance1 hashcode " + instance1.hashCode());
		System.out.println("Instance1 hashcode " + instance2.hashCode());
	}

}
