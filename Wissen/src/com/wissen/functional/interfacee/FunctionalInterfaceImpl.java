package com.wissen.functional.interfacee;

@FunctionalInterface
interface Functional {
	public double calculatePi(double radius);
}

public class FunctionalInterfaceImpl {

	public static void main(String[] args) {
		Functional functional = (r) -> {
			System.out.println(r);
			return 3.1413*r*r;
		};
		
		double result = functional.calculatePi(2.3);
		System.out.println(result);

	}

}
