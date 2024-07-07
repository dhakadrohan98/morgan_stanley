package com.wissen.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class JavaCallable implements Callable<Integer> {
	@Override
	public Integer call() throws InterruptedException {
		Random random = new Random();
		// int nextInt(int n) — returns the next random value of type int in the range
		// from 0 to n.
		// The method throws IllegalArgumentException, if n isn't positive
		Integer randomNo = random.nextInt(10);
		Thread.sleep(randomNo * 1000);
		return randomNo;	
	}
}
/*
 * Explanation: In the code, we have produced 10 different threads. Each thread
 * invokes the call() method, generates a random number, and returns it. The
 * get() method is used to receive the returned random number object obtained
 * from the different threads to the main thread. The get() method is declared
 * in the Future interface and implemented in the FutureTask class.
 */

public class CallableExmpGenerateRandomNumbersFrom0To10 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// FutureTask is the concrete class
		// creating an array of 10 objects of the FutureTask class
		FutureTask[] randomNoTasks = new FutureTask[10];
		// loop to create 10 new Threads
		for (int i = 0; i < 10; i++) {
			Callable callable = new JavaCallable();
			// create future task with callable
			randomNoTasks[i] = new FutureTask(callable);
			// Since FutureTask implements Runnable, one can create a Thread with a
			// FutureTask object
			Thread th = new Thread(randomNoTasks[i]);
			// new Thread(new Runnable());
			th.start();
		}

		// receive the random numbers.
		for (int i = 0; i < 10; i++) {
			int num = (int) randomNoTasks[i].get();
			System.out.println("The random number is " + num);
		}

	}
}
