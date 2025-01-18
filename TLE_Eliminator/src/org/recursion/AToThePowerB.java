package org.recursion;

public class AToThePowerB {

	//TC: O(b)
	private static void rec(long a, int b, int cons) {
		//base case
		if(b <= 1) {
			System.out.println(a);
			return;
		}
		rec(cons * a, b-1, cons);
	}
	
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		int cons = a;
		rec(a, b, cons);

	}

}
