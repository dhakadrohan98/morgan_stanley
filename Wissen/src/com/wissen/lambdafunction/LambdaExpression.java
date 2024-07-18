package com.wissen.lambdafunction;

interface Functional {
	public double calculateArea(double radius);
	
//	public double volume(double len, double bred, double heg);
}

public class LambdaExpression {

	public static void main(String[] args) {
		Functional functional = (radius) -> {
			double area = 3.1413 * radius * radius;
			return area;
		};
		double calculateArea = functional.calculateArea(2.3);
		System.out.println(calculateArea);
		
//		Functional functional1 = (len, bred, heg) -> {
//			return len * bred * heg;
//		};
//		
//		System.out.println("Volume of cube: " + functional1.volume(1.1, 2.2, 3.3));
	}

}
