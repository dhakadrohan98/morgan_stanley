package com.wissen.multithreading;

public class WithSychronizedKeywordWaitNotifyMethod {

	public static void main(String[] args) throws InterruptedException {
		TotalEarnings te = new TotalEarnings();
		te.start();
		synchronized(te) {
			te.wait();
		}
		System.out.println("Total earnings: "+ te.total);

	}

}
