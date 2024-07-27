package com.wissen.linkedlist;

public class ReverseLinkedListInGroupK {
	
	private ListNode reverseList(ListNode head) {
        //edge case
        if(head == null) {
            return head;
        }
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
    
    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while(temp != null && k > 0) {
            temp= temp.next;
            k -= 1;
        }
        return temp;
    } 
        
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp !=  null) {
            ListNode kthNode = getKthNode(temp, k);
            //base case
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            //first k group
            if(temp == head) {
                head = kthNode;
            }
            //Not first k group
            else {
                prevNode.next = kthNode;
            }
            //keeping track of last node of last k group
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
