package com.wissen.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(3);
		System.out.println("Starting.....");
		new MyThread(cdl);
		cdl.await();
		System.out.println("Finished....");
	}
}

class MyThread implements Runnable {
	CountDownLatch cdl;
	MyThread(CountDownLatch cdl) {
		new Thread(this).start();
		this.cdl = cdl;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				cdl.countDown();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
