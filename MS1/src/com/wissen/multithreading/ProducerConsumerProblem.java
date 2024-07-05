package com.wissen.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);

		Thread producer = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					buffer.put(i);
					System.out.println("Produced: " + i);
				}
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					int value = buffer.take();
					System.out.println("Consumed: " + value);
				}
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		});
		
		producer.start();
		consumer.start();
	}

}
