//FairnessParameterIlustrationExample
package com.wissen.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final ReentrantLock lock;

    public FairLockExample(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            // Simulate some work with the resource
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
    	FairLockExample example = new FairLockExample(true); // true for fair lock

        Runnable task = example::accessResource;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
	}
}



