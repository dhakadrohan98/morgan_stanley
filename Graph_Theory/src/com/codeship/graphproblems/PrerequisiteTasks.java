package com.codeship.graphproblems;

import java.util.*;

//TC: O(V) + O(M) + O(V+E)
//SC: O(V+E) + O(V) indegree

public class PrerequisiteTasks {
	
	//Solved this problem through Kahn's algorithm
    //Topological sort using BFS
    
    public boolean isPossible(int V,int M, int[][] prerequisites)
    {
        //make an adjacency list from prerequisites array
        List<List<Integer>> adj = new ArrayList<>();
        //O(V)
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        //O(M)
        for(int i = 0; i < M; i++) {
            int u = prerequisites[i][0];
            int v =  prerequisites[i][1];
            adj.get(u).add(v);
        }
        
        int[] indegree = new int[V];
        //count the indgree for each node, for it traverse through adjacent node & 
        //increase the count for that adjacent node in indegree array
        //O(V)
        for(int i = 0; i < V; i++) {
            for(int itr : adj.get(i)) {
                indegree[itr]++;
            }
        }
        //multi source bfs, store node whose indegree count as 0.
        //O(V)
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        //O(V+E)
        while(!queue.isEmpty()) {
            //remove the front node
            int node = queue.poll();
            //node is in your topo sort
            //So please disconnect it from adjacent nodes and remove it from the indegree
            topo.add(node);
            for(int itr : adj.get(node)) {
                indegree[itr]--;
                if(indegree[itr] == 0) {
                    queue.offer(itr);
                }
            }
        }
        //if nodes in topological sort is equal to no. of vertices(V)
        if(topo.size() == V) return true;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
