package com.codeship.graphproblems;

import java.util.*;

//TC: (V+M) where M is the no. of edges
//SC: O(V+M) where M is the no. of edges
public class CourseSchedule_GFG {
	
	public static int[] findOrder(int V, int M, ArrayList<ArrayList<Integer>> prerequisites) 
    {
         //make an adjacency list from prerequisites array
        List<List<Integer>> adj = new ArrayList<>();
        //O(V)
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        //O(M)
        for(int i = 0; i < M; i++) {
            int u = prerequisites.get(i).get(1);
            int v =  prerequisites.get(i).get(0);
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
        
        int[] topo = new int[V];
        int i = 0;
        //O(V+E)
        while(!queue.isEmpty()) {
            //remove the front node
            int node = queue.poll();
            //node is in your topo sort
            //So please disconnect it from adjacent nodes and remove it from the indegree
            topo[i] = node;
            i += 1;
            for(int itr : adj.get(node)) {
                indegree[itr]--;
                if(indegree[itr] == 0) {
                    queue.offer(itr);
                }
            }
        }
        //if nodes in topological sort is equal to no. of vertices(V)
        if(i == V) return topo;
        return new int[0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
