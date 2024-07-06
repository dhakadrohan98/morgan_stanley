package com.wissen.multithreading;

/*
 * When a method is declared as static synchronized, 
 * it acquires a class-level lock (also known as a monitor).
 * Only one thread can hold the class-level lock at a time, preventing concurrent execution of 
 * static synchronized methods within the same class.
 * 
 * Remember that static synchronization should be used judiciously, as excessive synchronization can lead to performance bottlenecks. Choose the appropriate level of synchronization based on your application’s requirements!
 */
class Display {
	public static synchronized void greet(String name) {
		for (int i = 0; i < 3; i++) {
			System.out.println("Good morning");
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class StaticSynchronizationExample {
	public static void main(String[] args) {
		Display d1 = new Display();
		Display d2 = new Display();

		Thread th1 = new Thread(() -> { d1.greet("Yuvraj"); });

		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				d2.greet("Dhoni");
			}
		});
		th1.start();
		th2.start();
	}
}
