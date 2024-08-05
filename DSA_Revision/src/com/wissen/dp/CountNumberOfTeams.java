package com.wissen.dp;

public class CountNumberOfTeams {

	public int numTeams(int[] rating) {
		// arr = [2,5,3,4,1]
		return countTeams(rating, 0, -1, -1, -1);
	}

	private int countTeams(int[] rating, int currentIndex, int first, int second, int third) {
//		Base Case: When currentIndex reaches the end of the array, 
		//we check if first, second, and third are valid indices. 
		//If they form a valid team, return 1; otherwise, return 0.
		if (currentIndex == rating.length) {
			if (first != -1 && second != -1 && third != -1) {
				if ((rating[first] < rating[second] && rating[second] < rating[third])
						|| (rating[first] > rating[second] && rating[second] > rating[third])) {
					return 1;
				}
			}
			return 0;
		}
		
// 		Recursive Case: For each index, we have two choices:
//		Include the current index in the team (update first, second, or third).
//		Skip the current index and move to the next one.

		int count = 0;

		// Try to include the current index in the team
		if (first == -1) {
			count += countTeams(rating, currentIndex + 1, currentIndex, second, third);
		} else if (second == -1) {
			count += countTeams(rating, currentIndex + 1, first, currentIndex, third);
		} else if (third == -1) {
			count += countTeams(rating, currentIndex + 1, first, second, currentIndex);
		}

		// Skip the current index
		count += countTeams(rating, currentIndex + 1, first, second, third);

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Wrong solution

//public int numTeams(int[] rating) {
//    int n = rating.length;
//    int sec = n-2;
//    int third = n-3;
//    return rec(n-1, sec, third, rating);
//}
//
//private int rec(int fir, int sec, int th, int[] arr) {
//    //base cases
//    //edge cases
//    if(fir < 0 ||  sec < 0 || th < 0) {
//        return 0;
//    }
//    
//    // i < j < k
//    if(arr[fir] < arr[sec] && arr[fir] < arr[th] && arr[sec] < arr[th]) {
//        return 1;
//    } else if(arr[fir] > arr[sec] && arr[fir] > arr[th] && arr[sec] > arr[th]) {
//        return 1;
//    }
//    
//    int op1 = rec(fir-1, sec, th, arr);
//    int op2 = rec(fir, sec-1, th, arr);
//    int op3 = rec(fir, sec, th-1, arr);
//    
//    return op1 + op2 + op3;
//}
