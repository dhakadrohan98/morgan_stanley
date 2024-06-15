package com.wissen.multithreading;

public class RunnableInterfaceJoinMethodExample implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunnableInterfaceJoinMethodExample runn = new RunnableInterfaceJoinMethodExample();
		Thread th1 = new Thread(runn, "t1");
		Thread th2 = new Thread(runn, "t2");
		Thread th3 = new Thread(runn, "t3");
		
		System.out.println("thread-1 execution started");
		th1.start();
		th1.join();
		System.out.println("thread-1 execution completed");
		
		System.out.println("thread-2 execution started");
		th2.start();
		th2.join();
		System.out.println("thread-2 execution completed");
		
		System.out.println("thread-3 execution started");
		th3.start();
		th3.join();
		System.out.println("thread-3 execution completed");
		
	}
	
}
