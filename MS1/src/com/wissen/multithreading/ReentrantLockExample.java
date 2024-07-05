package com.wissen.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Simulating multiple threads accessing a shared resource
        Runnable task = () -> {
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
                lock.unlock(); // Release the lock
            }
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}
