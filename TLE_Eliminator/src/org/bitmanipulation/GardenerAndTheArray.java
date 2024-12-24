package org.bitmanipulation;

import java.util.*;

//Div-2 (B)
//P: 1775/B
//A bit difficult to understand the implementation of approach
//TC: O(n * largest of |k|)
//SC: O(n * largest of |k|)
public class GardenerAndTheArray {
	
	private static void solve(Scanner sc) {
		int n = sc.nextInt();
        
        Map<Long, Long> mp = new HashMap<>();
        long[] k = new long[n];
        List<List<Long>> bits = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
            bits.add(new ArrayList<>());
            
            for (int j = 0; j < k[i]; j++) {
                long p = sc.nextLong();
                mp.put(p, mp.getOrDefault(p, 0L) + 1);
                bits.get(i).add(p);
            }
        }
        //print the map
        System.out.println(mp);
        for(List<Long> list : bits) {
        	System.out.println(list);
        }
        
        String ans = "NO";
        
        for (int i = 0; i < n; i++) {
            boolean found = true;
            for (long bit : bits.get(i)) {
            	//if at least one array has all its set bits appearing more than once across all arrays,
            	//then answer is yes(a duplicate free array EXISTS)
                if (mp.get(bit) == 1) {
                	//this number can not be removed if it is part of last 
                    found = false;
                    break;
                }
            }
            if (found) {
                ans = "YES";
                break;
            }
        }
        
        System.out.println(ans);
		
	}
	
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}


//2
//3
//2 1 5
//2 2 4
//2 2 3
//2
//2 1 2
//1 2
//2
//2 1 2
//2 2 3
//3
//2 1 5
//2 2 4
//1 2



//5
//3
//2 1 5
//2 2 4
//2 2 3
//2
//2 1 2
//1 2
//4
//3 1 2 4
//2 2 4
//4 1 2 5 6
//2 2 5
//5
//3 3 1 2
//3 2 5 3
//5 7 2 3 1 4
//5 1 2 6 3 5
//3 2 6 3
//2
//1 1
//1 2


