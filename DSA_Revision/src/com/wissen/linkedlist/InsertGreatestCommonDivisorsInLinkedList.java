package com.wissen.linkedlist;

public class InsertGreatestCommonDivisorsInLinkedList {

	// TC: O(n * log base to x ( min(a,b))
	// SC: O(n-1) to creat extra gcd node
	public int gcd(int a, int b) {
		while (a % b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
		return b;
	}

	public ListNode insertGreatestCommonDivisors(ListNode head) {
		// edge case
		if (head.next == null)
			return head;
		ListNode curr = head;

		// if there no two numbers remaining in list, it means we have found all gcd of
		// Linked list, return head;
		while (curr.next != null) {
			int gcd = gcd(curr.val, curr.next.val);
			ListNode gcdNode = new ListNode(gcd);
			// insert gcd node b/w curr & curr.next
			gcdNode.next = curr.next;
			curr.next = gcdNode;
			curr = gcdNode.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
