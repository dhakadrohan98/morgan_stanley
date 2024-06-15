package com.wissen.multithreading;

public class ProblemWihtoutSynchronizedKeyword {
	public static void main(String[] args) {
		TotalEarnings te = new TotalEarnings();
		te.start();
		System.out.println("Total earnings: "+ te.total);
	}
}
