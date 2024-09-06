package com.wissen.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeleteNodesFromLinkedListPresentInArray {
	//TC: O(n+m)  // n-> length of linked list & m-> length of array
    //SC: O(m)
    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer, Boolean> hmap = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            hmap.put(nums[i], true);
        }
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        
        while(head != null) {
            
            while(head.next != null && hmap.containsKey(head.next.val)) {
                if(head.next.next != null) {
                    head.next = head.next.next;
                }
                else {
                    head.next = null;
                }
            }
            
            head = head.next;
        }
        return dummyNode.next;
    }
}
