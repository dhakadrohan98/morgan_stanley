package com.wissen.dp.grids;

public class MaximumNumberOfPoints_RecursiveSol {
	
	//TC: O(n * m^2)
	//SC: O(n)
	public int maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;
        int maxPoints = 0;

        // Start from the last row & from any col(0,1,2) and find the maximum points
        for (int c = 0; c < cols; c++) {
            maxPoints = Math.max(maxPoints, maxPointsHelper(points, rows - 1, c));
        }

        return maxPoints;
    }

    private int maxPointsHelper(int[][] points, int r, int c) {
        // Base case: if we are at the first row, return the points at (r, c)
        if (r == 0) {
            return points[r][c];
        }

        int maxPrevPoints = Integer.MIN_VALUE;

        // Explore all columns in the previous row
        //The loop calculates the maximum points we can get from the previous row, considering the cost 
        //of moving from column ( k ) to column ( c ).
        for (int k = 0; k < points[0].length; k++) {
            maxPrevPoints = Math.max(maxPrevPoints, maxPointsHelper(points, r - 1, k) - Math.abs(c - k));
        }

        // Return the points at (r, c) plus the maximum points from the previous row.
        return points[r][c] + maxPrevPoints;
    }

    public static void main(String[] args) {
    	MaximumNumberOfPoints_RecursiveSol solution = new MaximumNumberOfPoints_RecursiveSol();
        int[][] points = {
            {1, 2, 3},
            {1, 5, 1},
            {3, 1, 1}
        };
        System.out.println(solution.maxPoints(points)); // Output: 9
    }
}
