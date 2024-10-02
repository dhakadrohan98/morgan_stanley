package com.wissen.functional.interfacee;

import java.util.function.Function;

public class FunctionaExample {

	public static void main(String[] args) {
		Function<String, Integer> lengthFunction = String::length;
		System.out.println("Length of RohanDhakad: " + lengthFunction.apply("RohanDhakad"));

	}

}
