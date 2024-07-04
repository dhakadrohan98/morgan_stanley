package com.wissen.functional.interfacee;


interface Functional {
	public double calculatePi(double radius);
}

public class FunctionalInterfacrImpl {

	public static void main(String[] args) {
		Functional functional = (r) -> {
			return 3.1413*r*r;
		};
		
		double result = functional.calculatePi(2);
		System.out.println(result);

	}

}
