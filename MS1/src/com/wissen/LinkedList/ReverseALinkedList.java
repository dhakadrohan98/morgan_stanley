package com.wissen.LinkedList;

public class ReverseALinkedList {
	// TC: O(n)
	// SC: O(1)
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
