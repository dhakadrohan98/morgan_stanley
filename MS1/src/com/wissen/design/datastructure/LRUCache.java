package com.wissen.design.datastructure;

import java.util.*;

/*
 * LRU cache is implemented by Rohan Dhakad
 */
class LRUCache {

	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		// insert functionality
		public static void insert(Node node) {
			if (hmap.containsKey(node.key)) {
				// remove from DLL(Node class)
				remove(node);
			}
			Node temp = head.next;
			head.next = node;
			node.prev = head;
			node.next = temp;
			temp.prev = node;
			// insert into hmap also with its address
			hmap.put(node.key, node);

		}

		public static void remove(Node node) {
			// if map contains node then remove it from map as well.
			if (hmap.containsKey(node.key)) {
				hmap.remove(node.key);
			}
			Node prevNode = node.prev;
			Node nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			node.next = null;
			node.prev = null;
		}
	}

	// global variables
	static Node head;
	static Node tail;
	int capacity;
	static Map<Integer, Node> hmap = new HashMap<>();

	// constructor to initialize the head & tail node
	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		int res = -1;
		if (hmap.containsKey(key)) {
			Node removeNode = hmap.get(key);
			res = removeNode.value;
			Node.remove(removeNode);
			Node.insert(removeNode);
		}
		return res;
	}

	public void put(int key, int value) {
		if (hmap.containsKey(key)) {
			Node currNode = hmap.get(key);
			currNode.value = value;
			Node.remove(currNode);
			Node.insert(currNode);
		} else {
			Node newNode = new Node(key, value);
			if (hmap.size() >= capacity) {
				Node.remove(tail.prev);
			} 
			Node.insert(newNode);
			hmap.put(key, newNode);
		}
	}
}
