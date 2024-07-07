package com.wissen.multithreading;

import java.util.Calendar;
import java.util.concurrent.*;

class Command implements Runnable {
	String taskName;

	public Command(String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		System.out.println(
				"Task name: " + this.taskName + " Current time: " + 
		Calendar.getInstance().get(Calendar.SECOND));
	}
}

public class SchedulerExecutorServiceExample {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(2);

		Runnable task1 = new Command("task1");
		Runnable task2 = new Command("task2");

		System.out.println("Current time: " + Calendar.getInstance().get(Calendar.SECOND));

		// Schedule task1 to run after 2 seconds
		threadPool.schedule(task1, 2, TimeUnit.SECONDS);

		// Schedule task2 to run after 5 seconds
		threadPool.schedule(task2, 5, TimeUnit.SECONDS);

		threadPool.shutdown();
	}
}
