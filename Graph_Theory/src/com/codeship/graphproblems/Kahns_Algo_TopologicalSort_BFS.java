package com.codeship.graphproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//TC: O(V+E) for directed graph traversing & O(V+(2*E)) for undirected graph traversing
//SC: O(2*V) indgree array & Queue
public class Kahns_Algo_TopologicalSort_BFS {
	
	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] indegree = new int[V];
        //count the indgree for each node, for it traverse through adjacent node & 
        //increase the count for that adjacent node in indegree array
        for(int i = 0; i < V; i++) {
            for(int itr : adj.get(i)) {
                indegree[itr]++;
            }
        }
        //multi source bfs, store node whose indegree count as 0.
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            //remove the front node
            int node = queue.poll();
            //node is in your topo sort
            //So please disconnect it from its adjacent nodes and remove it from the indegree
            topo.add(node);
            for(int itr : adj.get(node)) {
                indegree[itr]--;
                if(indegree[itr] == 0) {
                    queue.add(itr);
                }
            }
        }
        
        return topo;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
