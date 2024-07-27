package com.wissen.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

}

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		// edge case
		if (head == null) {
			return head;
		}
		ListNode curr = head;
		ListNode fast = null, slow = null;
		while (curr != null) {
			fast = curr.next;
			curr.next = slow;
			slow = curr;
			curr = fast;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
