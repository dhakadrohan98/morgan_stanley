package com.wissen.functional.interfacee;

import java.util.function.Consumer;

/**
 * The Consumer interface represents an operation that accepts a single input argument and returns 
 * no result.
 */
public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> greeter = (name) -> System.out.println("Hello " + name);
		greeter.accept("Alice");

	}

}
