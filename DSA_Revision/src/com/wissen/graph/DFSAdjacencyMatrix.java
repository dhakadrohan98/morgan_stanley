package com.wissen.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSAdjacencyMatrix {
	
	//TC: O(V^2)
	//SC: O(V^2), v-> total no. of vertexes in a graph
	private static void printDFS(int[][] adjMat, int sv) {
		int v = adjMat.length;
		boolean[] visited = new boolean[v];
		printDFSHelper(adjMat, visited, sv);
	}

	private static void printDFSHelper(int[][] adjMat, boolean[] visited, int sv) {
		System.out.println(sv);
		//marked current vertex as visited
		visited[sv] = true;
		int v = adjMat.length;
		for(int i=0; i<v; i++) {
			if(adjMat[sv][i] == 1 && visited[i] == false) {
				printDFSHelper(adjMat, visited, i);
			}
		}
		
	}
	
	
	private static void printBFS(int[][] adjMat, int sv) {
		int v = adjMat.length;
		boolean[] visited = new boolean[v];
		printBFSHelper(adjMat, visited, sv);
	}

	private static void printBFSHelper(int[][] adjMat, boolean[] visited, int sv) {
		int v = adjMat.length;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(sv);
		visited[sv] = true;
		while(!queue.isEmpty()) {
			int first = queue.poll();
			System.out.println(first);
			//iterate through all vertexes to check if edge exists or not
			for(int i=0; i<v; i++) {
				if(adjMat[first][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vertex: ");
		int vertexes = sc.nextInt();
		System.out.println("Enter edges: ");
		int edges = sc.nextInt();
		//adjacency matrix with v*v size
		int[][] adjMat = new int[vertexes][vertexes];
		
		for(int i=0; i<edges; i++) {
			int sv = sc.nextInt();
			int ev = sc.nextInt();
			adjMat[sv][ev] = 1;
			adjMat[ev][sv] = 1;
		}
		System.out.println("DFS travesal: ");
		//DFS traversal
		printDFS(adjMat, 0);
		//BFS traversal
		System.out.println("BFS traversal: ");
		printBFS(adjMat, 0);
	}
}

//input
//v
//6
///exact edges
//1 2
//2 3
//3 4
//4 5
//5 0
//0 1

//output:
//0
//1
//2
//3
//4
//5

//input 2:
//0 1
//0 2
//1 3
//1 4
//2 6
//3 5
//4 5
//6 5
