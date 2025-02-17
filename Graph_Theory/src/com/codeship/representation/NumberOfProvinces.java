package com.codeship.representation;

import java.util.*;

//TC: O(2 * (v + 2*E))
//SC: O(V + 2E) newly made Adjacency list + O(V) visited + O(V) recursion stack space in case of skew graph

public class NumberOfProvinces {

	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //create a adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        //create empty list at each index from 0 till v-1(th) index for adjList
        //O(n)
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        //O(2E)
        //to change the adjacency matrix to a list
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i != j && adj.get(i).get(j) == 1) {
                    //u -> v
                    adjList.get(i).add(j);
                    //v -> u
                    adjList.get(j).add(i);
                }
            }
        }
        //start dfs traversal on adjacency list
        boolean[] visited = new boolean[V];
        int provinces = 0;
        for(int node = 0; node < V; node++) {
            if(!visited[node]) {
                provinces++;
                //this recursive call will one component of a graph
                dfs(node, adjList, visited);
            }
        }
        
        return provinces;
    }
    
    private static void dfs(int node, List<List<Integer>> adjList, 
    boolean[] visited) {
        //mark current node as visited
        visited[node] = true;
        
        for(int itr : adjList.get(node)) {
            if(!visited[itr]) {
                dfs(itr, adjList, visited);
            }
        }
    }

}
