package com.wissen.multithreading;

public class RunnableInterfaceLambdaExpression {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			for(int i=0; i<5; i++) {
				System.out.println(i + " " + Thread.currentThread().getName());
			}
		};
		
		Thread th1 = new Thread(runnable, "thhh1");
		th1.start();
		
		Thread th2 = new Thread(runnable, "thhh2");
		th2.start();

	}

}
