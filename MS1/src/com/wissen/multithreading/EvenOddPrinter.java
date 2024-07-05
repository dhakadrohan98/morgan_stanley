package com.wissen.multithreading;

public class EvenOddPrinter {
	private int counter = 1;
	private static final int N = 10;
	
	public void printOddNumber() {
		synchronized (this) {
			while(counter <= N) {
				while(counter % 2 == 0) {
					try {
						this.wait();
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(counter + " ");
				counter++;
				this.notify();
			}
		}
	}
	
	public void printEvenNumber() {
		synchronized (this) {
			while(counter <= N) {
				while(counter % 2 != 0) {
					try {
						this.wait();
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(counter + " ");
				counter++;
				this.notify();
			}
		}
	}
	
	public static void main(String[] args) {
		EvenOddPrinter printer = new EvenOddPrinter();
		Thread th1 = new Thread(printer::printEvenNumber);
		Thread th2 = new Thread(printer::printOddNumber);
		th1.start();
		th2.start();
	}
}
