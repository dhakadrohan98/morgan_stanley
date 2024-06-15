package com.wissen.lambdafunction;

interface Functional {
	public double calculateArea(double radius);
}

public class LambdaExpression {

	public static void main(String[] args) {
		Functional functional = (radius) -> {
			double area = 3.1413 * radius * radius;
			return area;
		};
		
		double calculateArea = functional.calculateArea(2.3);
		System.out.println(calculateArea);

	}

}
