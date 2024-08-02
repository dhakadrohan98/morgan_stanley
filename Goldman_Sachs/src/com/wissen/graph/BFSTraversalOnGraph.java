package com.wissen.graph;

import java.util.*;

public class BFSTraversalOnGraph {

	public static void bfsTraverseHelper(int sr, int[][] adjMat, boolean[] visited) {
		int n = adjMat.length;
		Queue<Integer> queue = new LinkedList<>();
		// add the source node of a component & start putting its adjacent nodes into
		// queue wisely
		queue.offer(sr);
		visited[sr] = true;
		while (!queue.isEmpty()) {
			// take the visited node (level wise) from queue & print it
			int curr = queue.poll();
			System.out.print(curr + " ");
			// traverse through all node to put adjacent nodes into queue
			for (int i = 0; i < n; i++) {
				//if i node is connected & not visited(to avoid from infinite loop). then add it into
				//the queue & mark it as visited
				if(adjMat[curr][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
				}
			}
			System.out.println();
		}
	}
	
	//method will traverse through disconnected component of a graph
	public static void bfsTraverse(int[][] adjMat) {
		int n = adjMat.length;
		boolean[] visited = new boolean[n];
		int components = 0;
		
		for(int i=0; i<n; i++) {
			if(visited[i] == false) {
				components += 1;
				bfsTraverseHelper(i, adjMat, visited);
			}
		}
		System.out.println("");
		System.out.println("No. of component in a graph " + components);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total no. of vertexes");
		int vertex = sc.nextInt();
		System.out.println("Enter total no. of edges");
		int edges = sc.nextInt();
		int[][] adjMat = new int[vertex][vertex];
		
		for(int i=0; i<edges; i++) {
			int sv = sc.nextInt();
			int ev = sc.nextInt();
			//it is undirected graph
			adjMat[sv][ev] = 1;
			adjMat[ev][sv] = 1;
		}
		
		bfsTraverse(adjMat);

	}
}

//Ex : 1
// V = 8, E = 7
//0 1
//0 2
//1 4
//1 3
//3 5
//5 6
//5 7

// o/p;


//Ex : 2
//V = 7, E = 8
// 0 1
// 0 2
// 1 3
// 1 4
// 2 6
// 3 5
// 4 5
// 6 5

//output:
//0
//1
//2
//3
//4
//5
