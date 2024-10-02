package com.wissen.functional.interfacee;

import java.util.function.Supplier;

/**
 * Supplier interface represents a supplier of results
 */
public class SupplierExample {

	public static void main(String[] args) {
		Supplier<String[]> supplier = () -> new String[]{"Hi","Thread",""};
        String[] stringArr = supplier.get();
        for(String str : stringArr) {
        	System.out.println(str);
        }

	}

}
