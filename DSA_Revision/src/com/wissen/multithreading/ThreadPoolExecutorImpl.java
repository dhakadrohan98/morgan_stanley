package com.wissen.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorImpl {
	public static void main(String[] args) {
		ExecutorService executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
				new ArrayBlockingQueue<Runnable>(2), new CustomThreadFactory(), 
				new CustomRejectHandler());
		
		for (int i = 1; i <= 10; i++) {
			executor.submit(() -> {
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("task processed by:" + Thread.currentThread().getName());

			});
		}
		executor.shutdown();
	}
}

class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread th = new Thread(r);
		th.setPriority(Thread.NORM_PRIORITY);
		th.setDaemon(false);
		return th;
	}
}

class CustomRejectHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task rejected: " + r.toString());
	}
}

//Explanation
//4 tasks has been rejected because corePooSize=2, maximumPoolSize = 4, keepAliveTime = 10, 
//BlockingQueue.size = 2 can accommodate two tasks at most at a time
