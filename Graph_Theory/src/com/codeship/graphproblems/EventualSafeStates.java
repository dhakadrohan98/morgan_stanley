package com.codeship.graphproblems;

import java.util.*;

//TC: < O(V+2E)
//SC: O(4 * V)
public class EventualSafeStates {
	
	private boolean dfsCheck(int node, boolean[] vis, int[] pathVis,
		    int[] check, List<List<Integer>> adj) {
		        //mark current node as visited &  pathVisited
		        vis[node] = true;
		        pathVis[node] = 1;
		        //traverse through adjacent nodes
		        for(int itr: adj.get(node)) {
		            if(!vis[itr]) {
		                if(dfsCheck(itr, vis, pathVis, check, adj) == true) {
		                    return true;
		                }
		            }
		            else if(pathVis[itr] == 1) {
		                return true;
		            }
		        }
		        //while backtrack unmarked the path visit & mark current node as safe node
		        pathVis[node] = 0;
		        check[node] = 1;
		        //no cycle is found in the current path.
		        return false;
		    }

		    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
		        boolean[] vis = new boolean[V];
		        int[] pathVis = new int[V];
		        int[] check = new int[V];
		        //apply multi source dfs
		        for(int i = 0; i < V; i++) {
		            if(!vis[i]) {
		                dfsCheck(i, vis, pathVis, check, adj);
		            }
		        }
		        List<Integer> safeNodes = new ArrayList<>();
		        for(int i = 0; i < V; i++) {
		            if(check[i] == 1) {
		                safeNodes.add(i);
		            }
		        }
		        return safeNodes;
		    }
		    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
