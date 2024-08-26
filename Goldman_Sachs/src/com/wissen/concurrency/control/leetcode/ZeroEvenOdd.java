package com.wissen.concurrency.control.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
	
	private int n;
	private int lastPrinted;
	private Semaphore zeroSemaphore;
	private Semaphore oddSemaphore;
	private Semaphore evenSemaphore;

	public ZeroEvenOdd(int n) {
		this.n = n;
		this.lastPrinted = 0;

		this.zeroSemaphore = new Semaphore(1);
		this.oddSemaphore = new Semaphore(1);
		this.evenSemaphore = new Semaphore(1);

		try {
			this.oddSemaphore.acquire();
			this.evenSemaphore.acquire();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		int numZeroes = n;
		while (numZeroes > 0) {
			zeroSemaphore.acquire();
			printNumber.accept(0);
			numZeroes--;

			if (lastPrinted % 2 == 0) {
				oddSemaphore.release();
			} else {
				evenSemaphore.release();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		int numEven = n / 2;
		while (numEven > 0) {
			evenSemaphore.acquire();
			printNumber.accept(++lastPrinted);
			numEven--;
			zeroSemaphore.release();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		int numOdd = n - n / 2;
		while (numOdd > 0) {
			oddSemaphore.acquire();
			printNumber.accept(++lastPrinted);
			numOdd--;
			zeroSemaphore.release();
		}
	}
}
