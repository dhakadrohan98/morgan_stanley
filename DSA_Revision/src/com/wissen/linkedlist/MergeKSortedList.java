package com.wissen.linkedlist;

import java.util.*;

class Pair {
    int x;
    ListNode node;
    
    Pair(int x, ListNode node) {
        this.x = x;
        this.node = node;
    }
}

public class MergeKSortedList {
	
	//TC: O(k * logk) + O(n * k * 2logk)
	//SC: O(k)
	public ListNode mergeKLists(ListNode[] list) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.x - b.x);
        
        //TC: O(k * logk)
        //add head of all k list into min Priority Queue initially
        for(int i = 0; i < list.length; i++) {
            //put head of each list into PQ as pair <head.val, head>
            if(list[i] != null) {
                pq.offer(new Pair(list[i].val, list[i]));   
            }
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        
        //TC: O(n * k * 2logk)
        // n * k -> all elements of k sorted list will be inserted in PQ(not at a time) 
        //until queue becomes empty 
        while(!pq.isEmpty()) {
            Pair p = pq.poll(); // O(logk)
            //make temp's next point to removed node
            temp.next = p.node;
            //if next node of removed node is not null, it means in that linked list
            //some nodes are still remaining, then add next node of removed node into priorityQueue
            if(p.node.next != null) {
                pq.offer(new Pair(p.node.next.val, p.node.next)); //// O(logk)
            }
            
            //move temp pointer to next added node
            temp = temp.next;
        }
        return dummyNode.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
