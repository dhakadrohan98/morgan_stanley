package com.wissen.exception.handling;

public class TryWithMultipleBlockFinallyExample {

	public static void main(String[] args) {
		int i=0;
		int j=10;
		
		try {
			System.out.println(j/i);
		}
		catch(ArithmeticException e) {
			e.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally block executed irrespective of exception occurred or not");
			System.out.println("This block especially can be used to maintain all generating logs,cleanup "
					+ "code, such as close DB connection etc");
		}
		

	}

}
