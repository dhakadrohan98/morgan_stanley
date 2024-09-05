package com.wissen.math;

//32_64 test cases have been passed
public class FindMissingObservations {

	//TC: O(m+ n + rem) where rem is remaining after rem times iteration
	//SC: O(n)
	public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int fn = 0; // n1 + n2 + n3 + n4+------
        int fm = 0; // m1+ m2+ m3+ m4+------
        for(int i = 0; i < m; i++) {
            fm += rolls[i];
        }
        
        int lhs= (mean) * (n+m);
        fn = (lhs - fm);
        
//        System.out.println("lhs : " + lhs);
//        System.out.println("fm: " + fm);
//        System.out.println("lhs - fm: " + (lhs - fm));
//        System.out.println("m: " + m);
//        System.out.println("fm: " + fm + " fn: " + fn);
        //dice sum range
        int startVal = n;
        int endVal = n * 6;
        //sum of n observations is not in the range of dice
        if(fn < startVal || fn > endVal) {
            return new int[]{};
        }
        int quotient = fn / n;
        int remainder = fn % n;
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = quotient;
        }

        //distribute remainder equally over formed array
        int j=0;
        while(remainder > 0) {
        	res[j++] += 1;
        	remainder -= 1;
        }
        
        return res;
    }

	public static void main(String[] args) {
		int[] rolls = {4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5};
		int mean = 4;
		int n = 40;
		int[] missingRolls = missingRolls(rolls, mean, n);
		for(int val : missingRolls) {
			System.out.print(val + " ");
		}
	}

}
