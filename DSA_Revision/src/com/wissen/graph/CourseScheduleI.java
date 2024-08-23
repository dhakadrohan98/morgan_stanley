package com.wissen.graph;

import java.util.*;

// Ex: numCourses = 2, prerequisites = [[1,0],[0,1]]
public class CourseScheduleI {

	public boolean canFinish(int numCourses, int[][] pre) {
		List<List<Integer>> adj = new ArrayList<>();
		//create empty list in adjacency list
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0; i<pre.length; i++) {
			int actualCourse = pre[i][0];
			int preCourse = pre[i][1];
			adj.get(actualCourse).add(preCourse);
		}
		
		boolean[] visited = new boolean[numCourses];
        boolean[] helper = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            //start from any node(sequence wise) of each component
            if(visited[i] == false) {
                boolean ans = DFS(adj, i, visited, helper);
                if(ans == true) return false;
            }
        }
        //no cycle is detected
        return true;
	}

	 private boolean DFS(List<List<Integer>> adj, int i, boolean[] visited, boolean[] helper) {
	        visited[i] = true;
	        helper[i] = true;
	        
	        List<Integer> neighbours = adj.get(i);
	        for(int k = 0; k < neighbours.size(); k++) {
	            int curr = neighbours.get(k);
	            //if current node is visited in current DFS, it means cycle exists in current component
	            if(helper[curr] == true) return true;
	            // if curr node is not visited then peform dfs on it
	            if(visited[curr] == false) {
	                boolean ans = DFS(adj, curr, visited, helper);
	                //cycle is found
	                if(ans == true) return false;
	            }
	        }
	        ////mark unvisit the current node while performing backtracking in DFS (DFS in reverse order through 
            //backtracking)
	        //makr node unvisited in helper array while backtrack
	        helper[i] = false;
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
