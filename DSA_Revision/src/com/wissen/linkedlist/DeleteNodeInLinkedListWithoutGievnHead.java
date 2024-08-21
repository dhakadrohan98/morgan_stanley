package com.wissen.linkedlist;

public class DeleteNodeInLinkedListWithoutGievnHead {
	public void deleteNode(ListNode node) {
        ListNode prev = null;
        
        while(node.next != null) {
            //start from node.val
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
