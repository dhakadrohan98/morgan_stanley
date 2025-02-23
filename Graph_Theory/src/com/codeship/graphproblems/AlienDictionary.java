package com.codeship.graphproblems;

import java.util.*;
public class AlienDictionary {
	
	//works for multiple components
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
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
            //So please disconnect it from adjacent nodes and remove it from the indegree
            //if any node will come from the queue
            //it means it was safe node due to indegree[node] = 0
            topo.add(node);
            for(int itr : adj.get(node)) {
                indegree[itr]--;
                if(indegree[itr] == 0) {
                    queue.offer(itr);
                }
            }
        }
        
        return topo;
    }
    
    //K -> //no. of vertices
    public String findOrder(String[] words, int K) {
        int n = words.length;
        //no. of  vertices -> all diff characters present in words array
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //make empty vertices(unique characters)
        for(int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        
        // s1 = arr[i];
        // s2 = arr[i+1];
        for(int i =0; i < n-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            //take min length of two string for the comparison
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr < len; ptr++) {
                char ch1 = s1.charAt(ptr);
                char ch2 = s2.charAt(ptr);
                //if two characters are not equal lexicographically then
                //make a directed edge between them
                //str1 -> abcd (d->a) d should come before a
            	//str2 -> abca
                if(ch1 != ch2) {
                    // ch1 -> ch2
                    // pos(ch1_numeric_val) -> pos(ch2_numeric_val)
                    adj.get(ch1 - 'a').add(ch2 - 'a');
                    break;
                }
            }
        }
        
        List<Integer> topo = topologicalSort(adj);
        //convert the topo list into string
        String ans = "";
        for(int itr: topo) {
            ans = ans + (char)(itr + 'a');
        }
        return ans;
    }

}
