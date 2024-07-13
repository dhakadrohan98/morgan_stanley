package com.wissen.two.pointers;

public class PushDominoes {
	//TC: O(3n)
	//SC: O(3n)
	public static String pushDominoes(String str) {
		int n = str.length();
		int[] left = new int[n];
		int[] right = new int[n];

		// left force propogation
		int nearestLeftIndex = -1;
		for (int i = n - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (ch == 'L') {
				nearestLeftIndex = i;
			} else if (ch == 'R') {
				nearestLeftIndex = -1;
			}
			left[i] = nearestLeftIndex;
		}

		// right force propogation
		int nearestRightIndx = -1;
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == 'R') {
				nearestRightIndx = i;
			} else if (ch == 'L') {
				nearestRightIndx = -1;
			}
			right[i] = nearestRightIndx;
		}

		char[] res = new char[n];
		for (int i = 0; i < n; i++) {

			if (str.charAt(i) == '.') {
				int nearestLeft = left[i];
				int nearestRight = right[i];
				int leftAbs = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
				int rightAbs = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);
				if (leftAbs == rightAbs) {
					res[i] = '.';
				} else if (leftAbs < rightAbs) {
					res[i] = 'L';
				} else if (leftAbs > rightAbs) {
					res[i] = 'R';
				}
			} else {
				res[i] = str.charAt(i);
			}
		}

		return new String(res);
	}

	public static void main(String[] args) {
		String str = ".L.R...LR..L..";
		System.out.println(pushDominoes(str));

	}
}

//System.out.println("left propogation space");
//for(int num: left) {
//	System.out.print(num + " ");
//}
//System.out.println();
//System.out.println("right propogation space");
//for(int num: right) {
//	System.out.print(num + " ");
//}
