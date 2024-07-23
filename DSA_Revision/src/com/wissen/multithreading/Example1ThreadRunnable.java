package com.wissen.multithreading;

public class Example1ThreadRunnable extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
				print(i);
		}
	}
	
	public synchronized void print(int i) {
		System.out.println(Thread.currentThread().getName() + " started - " + i);
	}
	
	public static void main(String[] args) {
		Example1ThreadRunnable th1 = new Example1ThreadRunnable();
		Example1ThreadRunnable th2 = new Example1ThreadRunnable();
		th1.setName("th1");
		th2.setName("th2");
		th1.start();
		th2.start();
		
	}
}
