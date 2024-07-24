package com.wissen.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutor {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable myTask = null;
        
        for(int i=1; i<=4; i++) {
        	 // Define a simple task (Runnable)
            myTask = () -> {
            	try {
					Thread.sleep(500);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
                System.out.println("Asynchronous task executed by thread: " + Thread.currentThread().getName());
            };
        }

        // Submit the task for execution
        executor.execute(myTask);

        // Shutdown the executor (gracefully)
        executor.shutdown();
    }
}
