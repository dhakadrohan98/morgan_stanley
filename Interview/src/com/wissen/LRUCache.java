package com.wissen;

import java.util.HashMap;


//TC: O(1)
//SC: O(n)
//n is the capacity of the cache

//DLL: Doubly linked list
public class LRUCache {
	//Node class of key -> value pair
	private class Node {
		int key, value;
		Node prev, next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private final int capacity;
	private final HashMap<Integer, Node> map; // key,nodeAddress
	private final Node head, tail; //Initially head & tail's next & prev is pointing to null

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
		head.next = tail; //Initially head next will point to the tail.
		tail.prev = head; //Similarly tail prev will point to the head.
	}

	// get method
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		//if map contains a key then fetch the address of node & remove that node from DLL 
		//& again insert that node into DLL
		Node node = map.get(key);
		remove(node);
		insert(node);
		return node.value;
	}

	// put method
	public void put(int key, int value) {
		//if map contains a key then remove this key from the hashmap first.
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		//if map size is equals to the capacity then remove tail.prev element (Least recently used node) from DLL
		// Then insert <key,value> pair node into DLL
		if (map.size() == capacity) {
			remove(tail.prev);
		}
		insert(new Node(key, value));
	}

	// remove method
	private void remove(Node node) {
		//remove current node from map first & then remove from DLL.
		map.remove(node.key);
		//changing link of tail & tail.prev node to put new node just left to the tail node.
		Node prevNode = node.prev;
		Node nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		node.next = null;
		node.prev = null;
	}

	// insert method
	private void insert(Node curr) {
		//put current key & value into hashmap before inserting it into DLL.
		map.put(curr.key, curr);
		//changing link of head & head.next node to put new node just right to the head node
		Node nextNode = head.next;
		curr.next = nextNode;
		nextNode.prev = curr;
		head.next = curr;
		curr.prev = head;
	}
}
