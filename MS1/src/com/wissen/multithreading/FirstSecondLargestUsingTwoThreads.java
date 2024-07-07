package com.wissen.multithreading;

class LargestElementsTask extends Thread {
	private int[] arr;
	private int start, end;
	private int[] result;

	public LargestElementsTask(int[] arr, int start, int end, int[] result) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.result = result;
	}

	@Override
	public void run() {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = start; i < end; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] > second && arr[i] != first) {
				second = arr[i];
			}
		}
		result[0] = first;
		result[1] = second;
	}
}

public class FirstSecondLargestUsingTwoThreads {

	public static void main(String[] args) throws InterruptedException {
		int[] arr = { 10, 20, 4, 45, 99, 23, 78, 56, 89, 12 };
		//arr.length = 10;
		int numThreads = 4;
		int segmentSize = arr.length / numThreads;
		LargestElementsTask[] threads = new LargestElementsTask[numThreads];
		int[][] results = new int[numThreads][2];

		for (int i = 0; i < numThreads; i++) {
			int start = i * segmentSize;
//			System.out.println("i: " + i + " - start: " + start);
			int end = (i == numThreads - 1) ? arr.length : start + segmentSize;
//			System.out.println("i: " + i + " - end: " + end);
			results[i] = new int[2];
			threads[i] = new LargestElementsTask(arr, start, end, results[i]);
			threads[i].start();
		}

		int overallFirst = Integer.MIN_VALUE;
		int overallSecond = Integer.MIN_VALUE;

		for (int i = 0; i < numThreads; i++) {
			threads[i].join();
			int first = results[i][0];
			int second = results[i][1];

			if (first > overallFirst) {
				overallSecond = overallFirst;
				overallFirst = first;
			} else if (first > overallSecond && first != overallFirst) {
				overallSecond = first;
			}

			if (second > overallSecond && second != overallFirst) {
				overallSecond = second;
			}
		}

		System.out.println("First Largest: " + overallFirst);
		System.out.println("Second Largest: " + overallSecond);
	}
}
