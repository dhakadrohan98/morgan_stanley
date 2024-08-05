package com.wissen.geometry;

public class RectangleOverlap {
	
	 //TC: O(1)
    //SC: O(1)
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];
        
        int p1 = rec2[0];
        int q1 = rec2[1];
        int p2 = rec2[2];
        int q2 = rec2[3];
        
        if(q1 >= y2 || p1 >= x2 || y1 >= q2 || x1 >= p2) {
            return false;
        }
        else {
            return true;
        }
    }
    
	public static void main(String[] args) {
		int[] rec1 = {0,0,2,2};
		int[] rec2 = {1,1,3,3};
		//nums1 = {0,0,1,1};  nums2 = {1,0,2,1}
		//o/p: false
		System.out.println(isRectangleOverlap(rec1, rec2));

	}

}
