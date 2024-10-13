package com.wissen.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DivideIntervalsIntoMinimumNumberOfGroups {
	
	//TC: O(n * logn) due to sorting
    //SC: O(n) storing second point of each group in min heap
    public int minGroups(int[][] intervals) {
        //Sort the intervals based on starting point of each interval
        // Sort the 2D array based on the starting point of each interval
        Arrays.sort(intervals, (a, b) -> {
        	if(a[0] == b[0]) {
        		return a[1] - b[1];
        	}
        	return a[0] - b[0];
        });
        
        //priority queue (min_heap) to store the end points of the groups
        Queue<Integer> pq = new PriorityQueue<>();
        
        //iterate through intervals
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
             // If the top of the queue (smallest end time) is smaller than the current start time
            // we can merge the interval into an existing group, so we pop the earliest end time
            if(!pq.isEmpty() && start > pq.peek()) {
                pq.poll();
            }
            // Add the current interval's end time to the queue (new or updated group)
            pq.offer(end);
            
        }
        
        return pq.size();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
