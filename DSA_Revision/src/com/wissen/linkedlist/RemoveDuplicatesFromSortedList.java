package com.wissen.linkedlist;

public class RemoveDuplicatesFromSortedList {
	//TC: O(n)
    //SC: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;   
            } else {
                curr = curr.next;   
            }
        }
        return head;
    }
    
    //Test cases
    //[1,1,2]
    //[1,1,2,3,3]
    //[1,1,1]
}
