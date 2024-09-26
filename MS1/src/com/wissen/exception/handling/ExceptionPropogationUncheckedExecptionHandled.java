package com.wissen.exception.handling;

//unchecked excepon is thrown and handled, 
//it can be seen from the call stack that it is propagated
public class ExceptionPropogationUncheckedExecptionHandled {

	public static void method1() {
		method2();
	}
	
	public static void method2() {
		throw new ArithmeticException("Arithmetic Exception from method2");
	}

	public static void main(String[] args) {
		try {
			method1();
		}
		catch(Exception e) {
			System.out.println("Unchecked Exception handled");
		}
	}

}
