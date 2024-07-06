package com.wissen.multithreading;


//class level lock is demonstrated in this program
public class EvenOddUsingTwoThreads {
	
	private int n;
	private int currentNumber = 1;
	//class level locking
	private final Object lock = new Object();
	
	public EvenOddUsingTwoThreads(int n) {
		this.n = n;
	}
	
	public void printOdd() {
		while(currentNumber <= n) {
			//synchronized block starts
			synchronized (lock) {
				if(currentNumber % 2 != 0) {
					System.out.println("Odd: " + currentNumber);
					currentNumber++;
					lock.notify();
					
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void printEven() {
		while(currentNumber <= n) {
			//synchronized block starts
			synchronized (lock) {
				if(currentNumber % 2 == 0) {
					System.out.println("Even: " + currentNumber);
					currentNumber++;
					lock.notify();
					
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		EvenOddUsingTwoThreads printer = new EvenOddUsingTwoThreads(n);
		
		Thread oddThread = new Thread(printer::printOdd);
		Thread evenThread = new Thread(printer::printEven);
		
		oddThread.start();
		evenThread.start();
		
		try {
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
