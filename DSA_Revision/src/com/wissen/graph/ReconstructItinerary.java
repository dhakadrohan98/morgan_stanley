package com.wissen.graph;

import java.util.*;
public class ReconstructItinerary {
	
	//TC: O(2*n)
    //SC: O(2*n)
    public List<String> findItinerary(List<List<String>> tickets) {
        //to store departs with its all arrival places in lexical order
        Map<String, PriorityQueue<String>> hmap = new HashMap<>();
        for(int i=0; i < tickets.size(); i++) {
            String key = tickets.get(i).get(0);
            String val = tickets.get(i).get(1);
            if(!hmap.containsKey(key)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                hmap.put(key, pq);
            }
            hmap.get(key).offer(val);
        }
        LinkedList<String> res = new LinkedList<>();
        //perform dfs on nodes starting from JFK
        dfs("JFK", hmap, res);
        return res;
    }
    
    private void dfs(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
        PriorityQueue<String> arrivals = hm.get(dep);
        while(arrivals != null && !arrivals.isEmpty()) {
            //remove used arrival cities & passed them as depart origin for further journey
            dfs(arrivals.poll(), hm, res);
        }
        //if arrivals is not null & not empty, then add words into res after 
        //reaching the last recursion call
        res.offerFirst(dep);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
