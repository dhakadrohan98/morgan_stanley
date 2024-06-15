package com.wissen.multithreading;

public class ThreadClassExample extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadClassExample th1 = new ThreadClassExample();
		ThreadClassExample th2 = new ThreadClassExample();
		
		th1.start();
		th2.start();
	}
}
