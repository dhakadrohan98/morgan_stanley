package com.wissen.linkedlist;

public class MiddleOfLinkedList {
	public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	//test cases
	//[1,2,3,4,5] //odd no. elements
	//[1,2,3,4,5,6] //even no. elements
}
