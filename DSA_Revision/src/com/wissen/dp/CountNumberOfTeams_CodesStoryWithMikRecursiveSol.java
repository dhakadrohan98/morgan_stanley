package com.wissen.dp;

public class CountNumberOfTeams_CodesStoryWithMikRecursiveSol {

	public static int countTeams(int[] rating) {
		//count team for increasing + decresing conditions
		// Increasing sequence -> countTeamsHelper(rating, 0, 0, 0, true)
		//Decreasing sequence -> countTeamsHelper(rating, 0, 0, 0, false);
		return countTeamsHelper(rating, 0, 0, 0, true) + countTeamsHelper(rating, 0, 0, 0, false);
	}

	private static int countTeamsHelper(int[] rating, int index, int count, int last, boolean increasing) {
		if (count == 3) {
			return 1;
		}
		if (index == rating.length) {
			return 0;
		}

		int include = 0;
		if (count == 0 || (increasing == true && rating[index] > last) || (increasing == false && rating[index] < last)) {
			include = countTeamsHelper(rating, index + 1, count + 1, rating[index], increasing);
		}
		int exclude = countTeamsHelper(rating, index + 1, count, last, increasing);

		return include + exclude;
	}
	
	public static void main(String[] args) {
		int[] rating = { 2, 5, 3, 4, 1 };
		System.out.println(countTeams(rating));
	}
}
