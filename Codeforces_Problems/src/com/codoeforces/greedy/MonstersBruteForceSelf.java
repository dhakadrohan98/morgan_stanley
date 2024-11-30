package com.codoeforces.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonstersBruteForceSelf {

	//TC: O(n * (2*n))
	//SC: O(n + t)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<List<Integer>> result = new ArrayList<>();
		
		while(t > 0) {
			//number of monsters
			int n = sc.nextInt();
			//damage magnitude by Monocarp abilities in a single shot
			int k = sc.nextInt();
			int[] arr = new int[n];
			//initial health points of n no. of monsters
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			List<Integer> list = new ArrayList<>();
			int maxi = -1;
			int maxi_indx = -1;
			
			//repeat this process until all monsters die
			int steps_count = n;
			while(steps_count > 0) {
				for(int i = 0; i < n; i++) {
					if(maxi < arr[i]) {
						maxi_indx = i;
						maxi = arr[i];
					}
				}
				arr[maxi_indx] -= k;
				if(arr[maxi_indx] <= 0) {
					list.add(maxi_indx + 1);
				}
				System.out.println("maxi- " + maxi + " maxi_indx-" + maxi_indx);
				//print the reduced health array
				for(int i = 0; i < n; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
				
				//reset maxi & maxi_indx
				maxi = -1;
				maxi_indx = -1;
				steps_count -= 1;
			}
			
			result.add(new ArrayList<>(list));
			t--;
		}
		
		for(List<Integer> list : result) {
			for(int val : list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
