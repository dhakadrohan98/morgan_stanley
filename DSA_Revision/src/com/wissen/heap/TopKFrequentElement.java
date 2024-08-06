package com.wissen.heap;

import java.util.*;

class Pair {
    int num;
    int freq;
    
    public Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}

public class TopKFrequentElement {
	
	//TC: O(n + n*logn) //insert delete -> logn in min heap
    //SC: O(n + k)
    public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> hmap = new HashMap<>();
       int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a,b) -> a.freq - b.freq);
        for(int key : hmap.keySet()) {
            int value = hmap.get(key);
            if(pq.size() < k) {
                pq.offer(new Pair(key, value));
            }
            else if(pq.peek().freq < value) {
                pq.poll();
                pq.offer(new Pair(key, value));
            }
        }
        
        int[] res = new int[k];
        for(int i=0; i < k; i++) {
            Pair pair = pq.poll();
            res[i] = pair.num;
        }
        return res;
    }
    
	public static void main(String[] args) {
		int[] nums = {1,1,1,3,2,2};
		int k = 2;
		int[] topKFrequent = topKFrequent(nums, k);
		System.out.println(Arrays.toString(topKFrequent));
	}

}
