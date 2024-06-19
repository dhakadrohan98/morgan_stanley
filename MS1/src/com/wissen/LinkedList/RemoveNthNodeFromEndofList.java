package com.wissen.LinkedList;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        //edge cases
        if(head.next == null && n == 1) {
            head = null;
            return head;
        }
        if(head.next.next == null) {
            if(n == 1) {
                head.next = null;
                return head;
            }
        }
        
        //find length of LL
        int len = 1;
        ListNode temp = head;
        while(temp.next != null) {
            len++;
            temp = temp.next;
        }
        //len == n, then move head pointer one step ahead.
        if(len == n) {
            head = head.next;
            return head;
        }
        
        
        int size = len - n - 1;
        ListNode temp1 = head;
        //one more edge case when length of LL is 3 & n=2.
        if(size == 0) {
            temp1.next = temp1.next.next;
            return head;
        }
        
        int itr = 0;
        while(temp1 != null && itr < size) {
            temp1 = temp1.next;
            itr++;
        }
        temp1.next = temp1.next.next;
        return head;
    }
}
