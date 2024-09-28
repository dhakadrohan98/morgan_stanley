package com.wissen.multithreading;

import java.util.ArrayList;
import java.util.Hashtable;

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
//		Parent class
//		Object object = new Object();
		
		
		ThreadClassExample th1 = new ThreadClassExample();
		ThreadClassExample th2 = new ThreadClassExample();
		th1.setName("Rohan");
		th2.setName("Sanjeet");
		
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
