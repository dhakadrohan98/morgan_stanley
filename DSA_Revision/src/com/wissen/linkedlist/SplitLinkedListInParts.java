package com.wissen.linkedlist;

public class SplitLinkedListInParts {
	
	//TC: O(n) + O(k) , n -> length of LL & k -> length of parts
	//SC: O(k) (no extra space I am storing)
	
	public ListNode[] splitListToParts(ListNode head, int k) {
		// find size
		ListNode temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		ListNode res[] = new ListNode[k];
		temp = head;
		int avg = size / k;
		int extra = size % k;
		for (int i = 0; i < k; i++) {
			if (temp == null)
				break;
			ListNode curHead = temp;
			ListNode prev = null;
			int len = 0;
			while (temp != null && len < avg) {
				prev = temp;
				temp = temp.next;
				len++;
			}
			if (extra > 0) {
				prev = temp;
				temp = temp.next;
				extra--;
			}
			prev.next = null; // detach previous list
			res[i] = curHead; // insert head
		}
		return res;
	}
}
