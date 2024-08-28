package com.wissen.stack;

import java.util.*;

//Implement a stack using ArrayDequeue

//Implement a stack using array

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(5);
		q.addLast(4);
		q.addLast(7);
		q.addLast(9);
		q.addLast(10);
		
		// 5 4 7 9 10
		System.out.println(q);
		System.out.println("size " + q.size());
		
		int first = q.removeLast();
		int second = q.removeLast();
		int third = q.removeLast();
		System.out.println(first); //10
		System.out.println(second); //9
		System.out.println(third); //7
		
		System.out.println("top: " + q.peekLast());
	}
}
