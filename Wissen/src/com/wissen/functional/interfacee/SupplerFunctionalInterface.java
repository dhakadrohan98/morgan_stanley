package com.wissen.functional.interfacee;

import java.util.UUID;
import java.util.function.Supplier;

public class SupplerFunctionalInterface {

	public static void main(String[] args) {
        // Supplier to generate a unique identifier
        Supplier<String> uniqueIdSupplier = () -> UUID.randomUUID().toString();

        // Simulate a scenario where the unique ID is needed
        System.out.println("Unique ID: " + uniqueIdSupplier.get());
    }

}
