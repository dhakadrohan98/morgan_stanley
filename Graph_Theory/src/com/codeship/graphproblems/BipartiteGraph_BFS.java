package com.codeship.graphproblems;

import java.util.*;
public class BipartiteGraph_BFS {
	
	//0 -> Orange
    //1 -> Green
    private boolean checkIsBipartite(int startNode, int V, 
    ArrayList<ArrayList<Integer>> adj, int[] color) {
        //Initial configuration for BFS algo
        Queue<Integer> queue = new LinkedList<>();
        //insert the starting node into queue & mark it is as visited
        queue.offer(startNode);
        color[startNode] = 0;
        //insert the node into queue & mark them visited as well
        while(!queue.isEmpty()) {
            int node = queue.poll();
            //iterate through adjacency list
            for(int itr : adj.get(node)) {
                //if adjacent node is not colored yet
                if(color[itr] == -1) {
                    //coloring current node with oppsoite color to its parent node
                    color[itr] = 1 - color[node];
                    queue.offer(itr);
                }
                //if the adjacent guy having the same color, 
                //someone did color it on some other path
                else if(color[itr] == color[node]) {
                    return false;
                }
            }
        }
        //till now all nodes are colored with 2 color
        //it is a Bipartite graph
        return true;
    }
    
    
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] color = new int[V];
        //fill all cells with -1(not colored yet)
        for(int i = 0; i < V; i++) {
            color[i] = -1;
        }
        
        for(int i = 0; i < V; i++){
            //if current vertex is not colored
            if(color[i] == -1) {
                if(!checkIsBipartite(i, V, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
