package com.wissen.linkedlist;

public class IsPalindromeDoublyLinkedList {
	
	public static boolean isPalindrome(DoublyLinkedListNode head) {
		
		//get end pointer to the last node of linked list
		DoublyLinkedListNode end = head;
		int length = 1;
		while(end.next != null) {
			end = end.next;
			length++;
		}
		
		int mid;
		if(length % 2 == 0) { //if total no. of nodes is even, the calculating mid
			mid = length/2;
		} else { //if total no. of nodes is odd, the calculating mid
			mid = (length+1)/2;
		}
		
		DoublyLinkedListNode start = head;
		int count = 0;
		while(start != end || count < mid) { //mid for even no. of nodes, alternative to start <= end
			if(start.data != end.data) {
				return false;
			}
			start = start.next;
			end = end.prev;
			count++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList linkedlist = new DoublyLinkedList();
		int[] list = {1,2,2,1};
		linkedlist.createLinkedList(list);
		
		boolean palindrome = isPalindrome(linkedlist.head);
		System.out.println(palindrome);
	}
}
