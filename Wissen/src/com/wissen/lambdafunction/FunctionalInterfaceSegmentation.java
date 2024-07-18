package com.wissen.lambdafunction;

interface AreaCalculator {
	double calculateArea(double radius);
}

interface VolumeCalculator {
	double volume(double len, double bred, double heg);
}

public class FunctionalInterfaceSegmentation {

	public static void main(String[] args) {
		AreaCalculator areaCalculator = (radius) -> {
			return 3.14 * radius * radius;
		};
		System.out.println("Area of circle: " + areaCalculator.calculateArea(2.3));
		
		VolumeCalculator volumeCalculator = (len, bred, heg) -> {
			return len* bred * heg;
		};
		System.out.println("volume of cube: " + volumeCalculator.volume(1.1, 2.2, 3.3));
	}
}
