package com.wissen.CollectionsFramework;

public class ArrayListGrowMethodDemonstration {

	public static void main(String[] args) {
		int oldCapacity = 10;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		System.out.println(newCapacity);

	}

}
