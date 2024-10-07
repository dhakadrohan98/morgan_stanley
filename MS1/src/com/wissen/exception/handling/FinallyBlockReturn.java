package com.wissen.exception.handling;

public class FinallyBlockReturn {

	public static int method1() {
		try {
			System.out.println("Try block is executed but return statement will not be "
					+ "executed of try block due to the presence of finally block");
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

	public static void main(String[] args) {
		int result = method1();
		System.out.println(result);

	}

}
