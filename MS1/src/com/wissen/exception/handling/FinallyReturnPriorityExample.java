package com.wissen.exception.handling;

public class FinallyReturnPriorityExample {

	/*
	 * Post try block execution, finally block gets executed even though return
	 * statement is available inside try block. finally-block gets more priority
	 * than the return statement.
	 */
	@SuppressWarnings("finally")
	public static int getNo() {
		try {
			int i = 90 / 9;
			System.out.println(i);
			return i;
		} catch (NullPointerException e) {
			return 92;
		} finally {
			System.out.println("inside finally block");
			return 99; // o/p: 99
		}
	}

	public static void main(String[] args) {
		System.out.println(getNo());
	}

}
