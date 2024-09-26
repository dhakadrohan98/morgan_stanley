package com.wissen.exception.handling;

public class FinallyBlockReturn {

	public static int method1() {
		try {
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
