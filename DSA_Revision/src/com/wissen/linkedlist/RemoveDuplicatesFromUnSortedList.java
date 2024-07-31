package com.wissen.linkedlist;

import java.util.*;

public class RemoveDuplicatesFromUnSortedList {
	//TC: O(N)
	//SC: O(N)
	public Node removeDuplicates(Node head) {
		if (head == null) {
			return null;
		}

		HashSet<Integer> seen = new HashSet<>();
		Node curr = head;
		Node prev = null;

		while (curr != null) {
			if (seen.contains(curr.data)) {
				prev.next = curr.next; // Remove the duplicate node
			} else {
				seen.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}

		return head;
	}
}

//My approach get TLE on GFG

/*
 * public Node removeDuplicates(Node head) { HashMap<Integer, Integer> hmap =
 * new HashMap<>(); Node curr = head; while (curr != null) { int val =
 * curr.data; hmap.put(val, hmap.getOrDefault(val, 0) + 1); curr = curr.next; }
 * // System.out.println(hmap);
 * 
 * curr = head; Node prev = null; while (curr != null) { //if hmap contains curr
 * node data as key & curr node data is occurring more than once in a linked
 * list if (hmap.containsKey(curr.data) && hmap.get(curr.data) > 1) { int key =
 * curr.data; int val = hmap.get(key); //curr node val is present more than once
 * if(curr != null && curr.data == val && val > 1) { while(curr != null &&
 * curr.data == val && val > 1) { //decrease val while curr node val is present
 * & move curr one step ahead. val -= 1; curr = curr.next; } //update repeated
 * element curr reduced val (skipped elements) hmap.put(key, val); //simply
 * change the prev pointer to curr node. prev.next = curr; } } else { prev =
 * curr; curr = curr.next; } } return head; }
 */
