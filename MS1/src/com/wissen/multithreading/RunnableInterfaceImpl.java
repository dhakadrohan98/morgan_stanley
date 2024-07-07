package com.wissen.multithreading;

public class RunnableInterfaceImpl implements Runnable {
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunnableInterfaceImpl runnable = new RunnableInterfaceImpl();
		Thread th1 = new Thread(runnable, "MyThread1");
		Thread th2 = new Thread(runnable, "MyThread1");
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.start();

	}

}
