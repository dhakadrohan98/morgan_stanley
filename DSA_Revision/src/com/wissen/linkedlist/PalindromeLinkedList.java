package com.wissen.linkedlist;

import java.util.*;
public class PalindromeLinkedList {
	
	//Approach -2 (Stack ds)
    //TC : O(n)
    //SC: O(logn)
    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> st = new Stack<>();
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode itr = null;
        if(fast == null) {
            itr = slow;
        } else {
            itr = slow.next;
        }
        
        while(itr != null && !st.isEmpty()) {
            if(itr.val != st.peek()) {
                return false;
            }
            st.pop();
            itr = itr.next;
        }
        return true;
    }
	
	//List approach - 1
	//TC: O(n)
	//SC: O(logn)
	
	public boolean isPalindrome0(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow.next;
        List<Integer> list = new ArrayList<>();
        while(temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }
        
        //checking for palindrome with the help of list & mid node + 1 ahead cursor
        ListNode temp2 = head;
        int count = 0;
        while(count < list.size() && temp2 != null) {
            if(temp2.val != list.get(count)) {
                return false;
            }
            count++;
            temp2 = temp2.next;
        }
        
        return true;
    }
}

//nums1 = [4, 5, 5, 4]
//nums2 = [1,2,3,2,1]
//nums3 = [1,2,4,3,4,2,1]
