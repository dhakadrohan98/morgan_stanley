package com.wissen.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	private static final Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		// Simulating multiple threads accessing a shared resource
		Runnable task = () -> {
			for (int i = 1; i <= 5; i++) {
				try {
					lock.lock(); // Acquire the lock
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " is inside the critical section.");
					// Perform some work (e.g., update shared data)
				} finally {
					//The finally block in the code ensures that the lock is always released, 
					//regardless of whether an exception occurs within the try block. This is 
					//crucial for preventing deadlocks and ensuring that other threads can acquire the lock.
					lock.unlock(); // Release the lock
				}
			}
		};

		// Create and start multiple threads
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		thread1.start();
		thread2.start();
	}
}
