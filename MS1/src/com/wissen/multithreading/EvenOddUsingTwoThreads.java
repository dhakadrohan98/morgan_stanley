package com.wissen.multithreading;


//class level lock is demonstrated in this program
public class EvenOddUsingTwoThreads {
	
	private int n;
	private int currentNumber = 1;
	//class level locking
	//the new Object() is not automatically called; it’s just used as a shared lock for synchronization
	private static final Object lock = new Object();
	
	public EvenOddUsingTwoThreads(int n) {
		this.n = n;
	}
	
	public void printOdd() {
		while(currentNumber <= n) {
//			currentNumber is 1 (odd).
//			Enters synchronized block, prints “Odd: 1”.
//			Increments currentNumber to 2.
//			Calls lock.notify() to wake up any waiting thread.
//			Exits synchronized block.
			synchronized (lock) {
				if(currentNumber % 2 != 0) {
					System.out.println("Odd: " + currentNumber);
					currentNumber++;
					lock.notify(); // wake up any waiting thread
					
				} else {
					/*
					 * currentNumber is 2 (even). 
					 * Enters synchronized block, sees currentNumber is even. 
					 * Calls lock.wait() and waits.
					 */
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

//Explanation of above code
/*
 * Initialization: n is set to 10. currentNumber is initialized to 1. Two
 * threads are created: oddThread and evenThread, which will run printOdd and
 * printEven methods respectively. Execution Starting Threads: Both threads are
 * started almost simultaneously. Thread Execution Odd Thread (printOdd):
 * Iteration 1: currentNumber is 1 (odd). Enters synchronized block, prints
 * “Odd: 1”. Increments currentNumber to 2. Calls lock.notify() to wake up any
 * waiting thread. Exits synchronized block. Iteration 2: currentNumber is 2
 * (even). Enters synchronized block, sees currentNumber is even. Calls
 * lock.wait() and waits. Even Thread (printEven): Iteration 1: currentNumber is
 * 2 (even). Enters synchronized block, prints “Even: 2”. Increments
 * currentNumber to 3. Calls lock.notify() to wake up any waiting thread. Exits
 * synchronized block. Iteration 2: currentNumber is 3 (odd). Enters
 * synchronized block, sees currentNumber is odd. Calls lock.wait() and waits.
 * Alternating Execution Odd Thread (printOdd): Iteration 3: currentNumber is 3
 * (odd). Wakes up, enters synchronized block, prints “Odd: 3”. Increments
 * currentNumber to 4. Calls lock.notify(). Exits synchronized block. Iteration
 * 4: currentNumber is 4 (even). Enters synchronized block, sees currentNumber
 * is even. Calls lock.wait() and waits. Even Thread (printEven): Iteration 3:
 * currentNumber is 4 (even). Wakes up, enters synchronized block, prints “Even:
 * 4”. Increments currentNumber to 5. Calls lock.notify(). Exits synchronized
 * block. Iteration 4: currentNumber is 5 (odd). Enters synchronized block, sees
 * currentNumber is odd. Calls lock.wait() and waits. Continuing Until
 * Completion This alternating pattern continues until currentNumber exceeds n
 * (10). The sequence of printed numbers will be:
 * 
 * Odd: 1 Even: 2 Odd: 3 Even: 4 Odd: 5 Even: 6 Odd: 7 Even: 8 Odd: 9 Even: 10
 * Thread Termination Completion: Once currentNumber exceeds 10, both threads
 * will exit their respective loops and terminate. The main method waits for
 * both threads to finish using join().
 */
