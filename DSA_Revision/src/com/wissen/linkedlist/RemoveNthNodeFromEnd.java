package com.wissen.linkedlist;

public class RemoveNthNodeFromEnd {
	
	 //TC: O(2*n)
    //SC: O(1)
    public ListNode removeNthFromEnd(ListNode head, int k) {
        
        ListNode temp = head;
        int count = 0; 
        
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
        //Three edge cases
        if(count == 1) {
            return null;
        } 
        
        //if count == k, it means remove first node
        if(count == k) {
            return head.next;
        } 
           
        //if (count-k) == 1, remove first 2nd node
        if(count - k == 1) {
            head.next = head.next.next;
            return head;
        }
        
        int tillIndex = count - k;
        int cnt = 1;
        temp = head;
        
        while(temp != null && temp.next != null & cnt < tillIndex) {
            temp = temp.next;
            cnt++;
        }
        
        if(temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
