package com.wissen.matrix;

import java.util.Arrays;

public class SpiralMatrixIV {
	
	//TC: O(m*n) + O(k), k -> length of linked list
    //SC: O(m*n) not extra space
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        //initially res mat is filled with -1
        for(int[] temp: res) {
            Arrays.fill(temp, -1);
        }
        ListNode itr = head;
        int tr = 0, br = m - 1;
        int lc = 0, rc = n - 1; 
        
        while(itr != null) {
            for(int temp = lc; temp <= rc; temp++) {
                //if linked list has vanished then break from this loop
                if(itr == null) break;
                res[tr][temp] = itr.val;
                itr = itr.next;
            }
            tr++;
            
            for(int temp = tr; temp <= br; temp++) {
                //if linked list has vanished then break from this loop
                if(itr == null) break;
                res[temp][rc] = itr.val;
                itr = itr.next;
            }
            rc--;
            
            for(int temp = rc; temp >= lc; temp--) {
                 //if linked list has vanished then break from this loop
                if(itr == null) break;
                res[br][temp] = itr.val;
                itr = itr.next;
            }
            br--;
            
            for(int temp = br; temp >= tr; temp--) {
                //if linked list has vanished then break from this loop
                if(itr == null) break;
                res[temp][lc] = itr.val;
                itr = itr.next;
            }
            lc++;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
