package com.wissen.multithreading;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance = null;

	private ThreadSafeSingleton() {

	}

	public static ThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				ThreadSafeSingleton obj = ThreadSafeSingleton.getInstance();
				System.out.println("instance from th1 " + obj);
			}
		});

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ThreadSafeSingleton obj = ThreadSafeSingleton.getInstance();
				System.out.println("instance from th2 " + obj);
			}
		});
		
		th1.start();
		th2.start();
	}
}
