package com.wissen.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Callable<Integer> task = () -> {
			Thread.sleep(1000);
			return 123;
		};

		Future<Integer> future = executor.submit(task);

		try {
			// Do some other work while the task is running
			System.out.println("Doing other work...");
			
			// get the result of the task
			Integer result = future.get();
			System.out.println("Result of the task: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

	}

}
