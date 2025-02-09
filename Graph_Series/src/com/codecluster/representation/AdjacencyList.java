package com.codecluster.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of edges");
		int n = sc.nextInt();
		List<List<Integer>> adj = new ArrayList<>();
		
		//create empty list at n+1 positions
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		int itr = n;
		//Enter list
		while(itr-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			//undirected graph
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		//print the adjacency list
		for(int i = 1; i < n; i++) {
			System.out.print(i + " -> {");
			for(int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
}

//input:
//6
//1 2
//1 3
//3 4
//2 4
//2 5
//4 5
