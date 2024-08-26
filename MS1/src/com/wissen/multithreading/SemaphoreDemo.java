package com.wissen.multithreading;

import java.util.concurrent.Semaphore;

class SharedResource {
	static int count = 0;
}

class MyThread extends Thread {
	Semaphore sem;
	String threadName;

	public MyThread(Semaphore sem, String threadName) {
		this.sem = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			// Acquire a permit
			//Acquires a permit from this semaphore, blocking until one isavailable, or the thread is interrupted. 
			sem.acquire();
			System.out.println(threadName + " acquired a permit.");

			// Access the shared resource
			for (int i = 0; i < 5; i++) {
				SharedResource.count++;
				System.out.println(threadName + ": " + SharedResource.count);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Release the permit
			sem.release();
			System.out.println(threadName + " released the permit.");
		}
	}
}

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1); // Only one permit

		MyThread t1 = new MyThread(sem, "A");
		MyThread t2 = new MyThread(sem, "B");

		t1.start();
		t2.start();
	}
}
