package com.wissen.LinkedList;

public class DetectACycleInLL {
	public boolean hasCycle(ListNode head) {
        //base case
        if(head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
