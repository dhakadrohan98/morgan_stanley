package com.wissen.functional.interfacee;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) throws ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> task = () -> "Task executed and result returned";
        Future<String> future = executor.submit(task);
        
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

	}

}
