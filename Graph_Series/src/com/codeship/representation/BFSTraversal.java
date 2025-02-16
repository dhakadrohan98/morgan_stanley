package com.codeship.representation;

import java.util.*;

public class BFSTraversal {
	
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //store the ans
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        //queue to perform the bfs traversal
        Queue<Integer> q = new LinkedList<>();
        //initially add starting node into the queue & mark them as visited
        q.offer(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            //remove the first node from queue & add into ans
            int node = q.poll();
            bfs.add(node);
            //traverse through adjacency list
            for(int itr: adj.get(node)) {
                if(!vis[itr]) {
                    vis[itr] = true;
                    q.offer(itr);
                }
            }
            
        }
        return bfs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
