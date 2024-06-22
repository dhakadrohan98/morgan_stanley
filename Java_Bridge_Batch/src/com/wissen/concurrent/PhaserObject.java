package com.wissen.concurrent;

import java.util.concurrent.Phaser;

public class PhaserObject {

	public static void main(String[] args) {
		Phaser phsr = new Phaser(1);
		new MyThread2(phsr, "A");
		new MyThread2(phsr, "B");
		new MyThread2(phsr, "C");
		new MyThread2(phsr, "D");
		new MyThread2(phsr, "E");

		int currPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("currPhase " + currPhase + " is completed");
		
		currPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("currPhase " + currPhase + " is completed");
		
		currPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("currPhase " + currPhase + " is completed");
		
		phsr.arriveAndDeregister();
		
		if(phsr.isTerminated()) {
			System.out.println("Finished...");
		}
	}
}

class MyThread2 implements Runnable {

	Phaser phsr;
	String name;

	public MyThread2(Phaser phsr, String name) {
		this.phsr = phsr;
		this.name = name;
		this.phsr.register();
		new Thread(this).start();
	}

	@Override
	public void run() {
		// 30
		// 30
		// 40
		System.out.println("Thread " + name + " beginning phase one");
		phsr.arriveAndAwaitAdvance();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + name + " beginning phase two");
		phsr.arriveAndAwaitAdvance();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + name + " beginning phase three");
//		phsr.arriveAndAwaitAdvance();
		phsr.arriveAndDeregister();
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Thread " + name + " beginning phase four");
	}
}
