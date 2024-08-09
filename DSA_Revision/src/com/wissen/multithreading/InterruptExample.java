package com.wissen.multithreading;

public class InterruptExample {
	
	public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });

        thread.start();
        thread.interrupt();
    }
}
