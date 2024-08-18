package com.wissen.math;

import java.util.*;
public class MinimumAreaRectangle {

	//[ [1,1],[1,3],[3,1],[3,3],[2,2] ]
	//TC: O(n^2)
	//SC: O(n)
	public static int minAreaRect(int[][] points) {
		int minArea = Integer.MAX_VALUE;
		Set<String> visited = new HashSet<>();
		
		for(int[] point1: points) {
			int x1 = point1[0];
			int y1 = point1[1];
			//For each point (x1, y1) in the list of points, we check all previously visited points (x2, y2)
			for(String point2 : visited) {
				String[] coords = point2.split(",");
				int x2 = Integer.valueOf(coords[0]);
				int y2 = Integer.valueOf(coords[1]);
				//For each pair of points (x1, y1) and (x2, y2), we check if the points (x1, y2) and (x2, y1) 
				//also exist in the visited set. If they do, it means these four points can form a rectangle.
				if(visited.contains(x1 + "," + y2) && visited.contains(x2 + "," + y1)) {
					int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
					minArea = Math.min(area, minArea);
				}
			}
			visited.add(x1 + "," + y1);
			
		}
		
		return minArea != Integer.MAX_VALUE ?  minArea : 0;
	}
	
	public static void main(String[] args) {
		int[][] points = {{1,1}, {1,3}, {3,1}, {3,3}, {2,2}};
		System.out.println(minAreaRect(points));

	}

}
