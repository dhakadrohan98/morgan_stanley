package com.wissen.linkedlist;

public class DoublyLinkedList {
	public DoublyLinkedListNode head;

	public DoublyLinkedList() {
		this.head = null;
	}

	public void insertNodeAtHead(DoublyLinkedListNode node) {
		if (head != null) {
			node.next = head;
			head.prev = node;
			head = node;
		} else { //first node of DLL
			head = node;
		}
	}

	public void createLinkedList(int[] lst) {
		for (int i = lst.length - 1; i >= 0; i--) {
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(lst[i]);
			insertNodeAtHead(newNode);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		DoublyLinkedListNode temp = head;
		while (temp != null) {
			result.append(temp.data);
			temp = temp.next;
			if (temp != null) {
				result.append(", ");
			}
		}
		return result.toString();
	}
}
