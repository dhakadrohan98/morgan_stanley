package com.wissen.lambdafunction;

interface Functional1 {
	public double area(double radius);
}

public class Practice {

	public static void main(String[] args) {
		Functional1 functional = (radius) -> {
			return 3.14 * radius * radius;
		}; 

		System.out.println(functional.area(2)+ "cm^2");
	}

}
