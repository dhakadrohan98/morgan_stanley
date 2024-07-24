package com.wissen.graph;

import java.util.Scanner;

public class DFSAdjacencyMatrix {
	
	//TC: O(V^2)
	//SC: O(V^2), v-> total no. of vertexes in a graph
	private static void print(int[][] adjMat, int sv) {
		int v = adjMat.length;
		boolean[] visited = new boolean[v];
		printHelper(adjMat, visited, sv);
	}

	private static void printHelper(int[][] adjMat, boolean[] visited, int sv) {
		System.out.println(sv);
		//marked current vertex as visited
		visited[sv] = true;
		int v = adjMat.length;
		for(int i=0; i<v; i++) {
			if(adjMat[sv][i] == 1 && visited[i] == false) {
				printHelper(adjMat, visited, i);
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
		print(adjMat, 0);

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
