package com.codoeforces.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


//TC: O((t*n) + (n*logn))
//SC: O(n) storing cost,max_resident into pair array
public class HelmetsInNightLight {
	
	static class Pair {

		long cost;
		long maxResident;

		Pair(long cost, long maxResident) {
			this.cost = cost;
			this.maxResident = maxResident;
		}
	}

	static class PairSortingComparator implements Comparator<Pair> {

		// sort the element on the basis of cost only.
		@Override
		public int compare(Pair p1, Pair p2) {
			return Long.compare(p1.cost, p2.cost);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// store results in result array
		long [] result = new long[t];

		//No. of test cases
		for (int i = 0; i < t; i++) {	
			int n = sc.nextInt(); // no. of resident
			int p = sc.nextInt(); // cost of pak chanek to share the announcement
			
			long[] a = new long[n];
			long[] b = new long[n];
//			n integers a1,a2,a3,…,an (1 ≤ ai ≤ 10^5) — the maximum number of residents that each 
//			resident can share the announcement to.
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}

//			n integers b1,b2,b3,…,bn (1 ≤ bi ≤ 10^5) — the cost for each resident to share 
//			the announcement to one other resident.
			for (int j = 0; j < n; j++) {
				b[j] = sc.nextInt();
			}

			// main logic
			Pair[] allAdjacentResidentCost = new Pair[n];

			for (int j = 0; j < n; j++) {
				allAdjacentResidentCost[j] = new Pair(b[j], a[j]);
			}

			Arrays.sort(allAdjacentResidentCost, new PairSortingComparator());
			
			//print the sorted pair array
//			for(int j = 0; j < n; j++) {
//				System.out.println
//				(allAdjacentResidentCost[j].cost + " " + allAdjacentResidentCost[j].maxResident);
//			}
			
			int residents = 1;
			long minimumCost = Long.valueOf(p);
			
			for(int k = 0; k < n; k++) {
				long cost = allAdjacentResidentCost[k].cost;
				long maxResident = allAdjacentResidentCost[k].maxResident;
				
				//if pak chanek cost is lesser than current ai -> bi cost
				if(p < cost) {
					break;
				}
				
				minimumCost += Long.valueOf((cost * (Math.min(maxResident, n-residents))));
				residents += Math.min(maxResident, n-residents);
			}
			minimumCost += Long.valueOf((p *(n - residents)));
			result[i] = Long.valueOf(minimumCost);
		}

		//print the result
		for(int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		
		sc.close();
	}
}

/**
 * test_case:1
1
6 3
2 3 2 1 1 3
4 3 2 6 3 6
o/p: 16

test_case:2
1
1 100000
100000
1
o/p: 100000

test_case:3
4 94
1 4 2 3
103 96 86 57
o/p: 265

combined_test_case:
3
6 3
2 3 2 1 1 3
4 3 2 6 3 6
1 100000
100000
1
4 94
1 4 2 3
103 96 86 57

**/
