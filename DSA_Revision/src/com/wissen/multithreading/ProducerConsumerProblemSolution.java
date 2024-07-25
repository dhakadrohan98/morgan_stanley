package com.wissen.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblemSolution {

	public static void main(String[] args) {
		BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);

		Thread producer = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					buffer.put(i); //Use put() to handle buffer overflow
					System.out.println("Produced: " + i);
				}
			} catch (Exception e) {
				Thread.currentThread().interrupt();
				System.err.println("Producer was interrupted");
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
				System.err.println("Consumer was interrupted");
			}
		});

		producer.start();
		consumer.start();
	}

}
