package com.wissen.simulation;

public class FractionAdditionSubtraction {

	// TC: O(n)
	// SC: O(1)

	public String fractionAddition(String expr) {
		int n = expr.length();
		int num = 0;
		int den = 1;
		int i = 0;

		while (i < n) {
			int currNum = 0;
			int currDen = 0;

			boolean isNegative = (expr.charAt(i) == '-'); // false or true

			// if first character is + or -, then skip this character
			if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
				i++;
			}
			// build the currNumerator
			while (i < n && Character.isDigit(expr.charAt(i))) {
				int val = expr.charAt(i) - '0';
				currNum = (currNum * 10) + val;
				i++;
			}

			i++; // skip the '/' character which is between numerator and denominator

			if (isNegative) {
				currNum = -currNum;
			}

			// build the currDenominatpr
			while (i < n && Character.isDigit(expr.charAt(i))) {
				int val = expr.charAt(i) - '0';
				currDen = (currDen * 10) + val;
				i++;
			}
			// calculate new numerator & denominator
			num = num * currDen + currNum * den;
			den = den * currDen;

			// take gcd of num & den & then individually divide num & den with its gcd to
			// Simply original
			// num/den to its lowest possible values
			int gcd = gcd(Math.abs(num), den); // gcd(-3, 6) = 3;
			num = num / gcd;
			den = den / gcd;
		}
		// Return the result in the form "numerator/denominator"
		return num + "/" + den;
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
