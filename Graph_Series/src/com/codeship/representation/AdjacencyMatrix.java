package com.codeship.representation;

import java.util.Scanner;

public class AdjacencyMatrix {

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
			adj[u][v] = 1;
			adj[v][u] = 1;
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
//1 2
//1 3
//3 4
//2 4
//2 5
//4 5