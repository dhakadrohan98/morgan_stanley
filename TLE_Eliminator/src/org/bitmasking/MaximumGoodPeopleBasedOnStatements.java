package org.bitmasking;

public class MaximumGoodPeopleBasedOnStatements {
	
	//TC: O(2^n *n*n)
	//SC: O(1)
	public int maximumGood(int[][] statements) {
        int n = statements.length;
        int max_good_person = 0;
        //explore all possible combinations for statements i,j
        for(int mask = 0; mask < (1 << n); mask++) {
        	//mask represents the set of good people
        	boolean flag = true;
        	for(int i = 0; i < n; i++) {
        		if((mask & (1<<i)) == 0) { //person i is a bad people
        			continue;//I don't need to verify his/her statements
        		}
        		for(int j = 0; j < n; j++) {
        			//Making an assumption by ourself about statement made by i for j
        			int good = (mask & (1 << j)) >= 1 ? 1 : 0;
        			//If our assumption is contradicting with given values in statements[i][j]
        			if((statements[i][j]==1 && good==0) || (statements[i][j]==0 && good==1)){
                        flag=false;
                        break;
                    }
        		}
        		//our assumption is contradicted with given values of statements[i][j]
        		if(!flag) break;
        	}
        	//if we found the valid combinations
        	if(flag) {
        		max_good_person = Math.max(max_good_person, Integer.bitCount(mask));
        	}
        }
        return max_good_person;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
