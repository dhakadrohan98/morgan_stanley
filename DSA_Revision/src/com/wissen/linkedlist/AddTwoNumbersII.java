package com.wissen.linkedlist;

public class AddTwoNumbersII {
	
		//TC: O(n+m) reverse both list + O(m+n) to build the list + O(m+n) reverse the built sum list
		//TC O(3*(m+n))
		//SC: O(n+m) to build the sum list
		
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode l1ReversedList = reverseList(l1);
	        ListNode l2ReversedList = reverseList(l2);
	        //iterate over the reversed list & add their node values & make a new list
	        ListNode temp1 = l1ReversedList;
	        ListNode temp2 = l2ReversedList;
	        //keep track of prevNode of new Sum Linked list
	        ListNode prevNode = null;
	        int carry = 0;
	        
	        while(temp1 != null || temp2 != null || carry != 0) {
	            //assign whatever carry is there to num
	            int num = carry;
	            if (temp1 != null) {
	                num += temp1.val;
	                temp1 = temp1.next;
	            }
	            
	            if (temp2 != null) {
	                num += temp2.val;
	                temp2 = temp2.next;
	            }
	            
	            //carry can be caulcated after addition from two given linked list
	            carry = num / 10;
	            ListNode newNode = new ListNode(num % 10);
	            //connect prev node to newNode
	            if(prevNode != null) {
	                prevNode.next = newNode;
	            } else {
	                // Initialize the head of the result list, it will be in use when we need to reverse the result list
	                l1ReversedList = newNode; 
	            }
	            
	            prevNode = newNode;
	        }
	        
	        //reverse new result list
	        ListNode sumHead = reverseList(l1ReversedList);
	        return sumHead;
	        
	    }
	    
	    private ListNode reverseList(ListNode head) {
	        ListNode curr = head;
	        ListNode fast = null, slow = null;
	        while(curr != null) {
	            fast = curr.next;
	            curr.next = slow;
	            slow = curr;
	            curr = fast;
	        }
	        return slow;
	    }
}
