package com.wissen.greedy;

public class CountNumberofTeams_Greedy_Approach {
	
	 //TC: O(n^2)
    //SC: O(1)
    
    public int numTeams(int[] nums) {
        int n = nums.length;
        int teams = 0;
        
        for(int i=1; i<n; i++) {
            int smallerLeft = 0;
            int smallerRight = 0;
            int largerLeft = 0;
            int largerRight = 0;
            
            //Store smaller & larger elements count for left portion w.r.t. i
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    smallerLeft++;
                } else if(nums[j] > nums[i]) {
                    largerLeft++;
                }
            }
            
             //Store smaller & larger elements count for right portion w.r.t. i
            for(int k=i+1; k<n; k++) {
                if(nums[i] < nums[k]) {
                    largerRight++;
                } else if(nums[i] > nums[k]) {
                    smallerRight++;
                }
            }
            
            teams += (smallerLeft * largerRight) + (smallerRight * largerLeft);
        }
         
        return teams;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
