package com.wissen.multithreading;

public class TestDeadLockEx {

	public static void main(String[] args) {
		final String resource1 = "sainik jaiswal";
		final String resource2 = "ratan tata";

		Thread th1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (resource2) {
					System.out.println("Thread 1: locked resource 2");
				}
			}
		};

		Thread th2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (resource1) {
					System.out.println("Thread 2: locked resource 1");
				}
			}
		};


		th1.start();
		th2.start();

	}

}
