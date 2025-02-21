package com.codeship.graphproblems;

import java.util.*;

//TC: O(V+E) queue traversing + O(nlogn) for sorting safeNodes
//SC: O(2*V) + O(V) queue data structure
public class EventualSafeStates_BFS_TopologicalSort {
	
	public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        //Make reverse adjacency list to reverse the edges
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int u = 0; u < V; u++) {
            //indegree will be calculated for u
            //traverse through adjacent nodes & reverse all edges of a graph
            for(int v : adj.get(u)) {
                //u -> v
                //v -> u(indegree for u will be calculated after revering all the edges of graph)
                adjRev.get(v).add(u);  
                indegree[u]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        //Add terminal node (whose indegree is )0 into Queue initially & 
        //then backtrack from this terminal node towards non cyclic path
        //to know safe Nodes
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            //Add the current node into safeNode ans because this node has indegree 0 
            //and that's why it was present into the queue
            safeNodes.add(node);
            for(int itr : adjRev.get(node)) {
                //reduce the indgree & disconnect the edges from an node
                indegree[itr]--;
                if(indegree[itr] == 0) {
                    queue.offer(itr);
                }
            }
        }
        //sor the safeNodes list according to question
        Collections.sort(safeNodes);
        return safeNodes;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
