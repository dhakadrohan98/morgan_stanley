package com.wissen.design.pattern;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

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
				System.out.println("instance from th1 " + obj.hashCode());
			}
		});

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ThreadSafeSingleton obj = ThreadSafeSingleton.getInstance();
				System.out.println("instance from th2 " + obj.hashCode());
			}
		});
		
		th1.start();
		th2.start();
	}
}
