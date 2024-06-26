package com.wissen.concurrent.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NonThreadSafeExample {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("first");
		list.add("sec");
		list.add("third");
		list.add("fourth");
		list.add("fifth");
		
		//implementing run() method of Runnable interface using lambda expression
		Runnable t1 = () -> {
			//thread-1 task reading the data
			for(String str: list) {
				System.out.println(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable t2 = () -> {
			//thread-2 task //adding new data
			list.add("new item-1");
			list.add("new item-2");
			list.add("new item-3");
			
		};
		
		//starting thread
		new Thread(t2).start();
		new Thread(t1).start();

	}

}
