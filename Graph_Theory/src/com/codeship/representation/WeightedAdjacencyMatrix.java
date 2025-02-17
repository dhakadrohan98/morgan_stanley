package com.codeship.representation;

import java.util.Scanner;

public class WeightedAdjacencyMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of nodes");
		int n = sc.nextInt();
		int[][] adj = new int[n+1][n+1];
		System.out.println("Enter no. of edges");
		int e = sc.nextInt();
		
		for(int i = 1; i <= e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int weight = sc.nextInt();
			adj[u][v] = weight;
			adj[v][u] = weight;
		}
		
		
		//print the adjacency matrix 
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

}

//input
//5
//6
//1 2 2
//1 3 3
//3 4 4
//2 4 1
//2 5 6
//4 5 7
