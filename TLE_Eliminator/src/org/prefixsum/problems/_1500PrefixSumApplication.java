package org.prefixsum.problems;

import java.util.Scanner;

//TC: O(n+q)
//SC: O(2*n)
public class _1500PrefixSumApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//input for  array
		int n = sc.nextInt();
		long[] arr = new long[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextLong();
		}
		//main logic
		//build two prefix array
		//conside 1 based indexing because l & r for qth query will be based on 1 based indexing
		long[] prefix1 = new long[n+1];
		long[] prefix2 = new long[n+1];
		for(int i = 1; i <= n; i++) {
			prefix1[i] = prefix1[i-1] + (i * arr[i]);
			prefix2[i] = prefix2[i-1] + arr[i];
		}
		
		//input for queries
		int q = sc.nextInt();
		while(q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			long ans = (prefix1[r] - prefix1[l-1]) - ((l-1) * (prefix2[r] - prefix2[l-1]));
			System.out.println(ans);
		}

	}

}

//Test cases-

//7
//1 3 5 3 4 7 2
//3
//2 5
//1 6
//3 6

//o/p-
//38
//96
//51


