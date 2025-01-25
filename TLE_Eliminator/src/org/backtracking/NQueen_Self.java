package org.backtracking;

import java.util.*;

public class NQueen_Self {
	
	private boolean check(int r, int c, List<String> v, int n) {
		// check for vertical direction
		for(int i = r; i >= 0; i--) {
			if(v.get(i).charAt(c) == 'Q') return false;
		}
		
		//check for left diagonal
		for(int i=r, j=c; i >= 0 && j >= 0; i--, j--) {
			if(v.get(i).charAt(j) == 'Q') return false;
		}
		
		//check for right diagonal
		for(int i=r, j=c; i >= 0 && j < n; i--, j++) {
			if(v.get(i).charAt(j) == 'Q') return false;
		}
		
		return true;
	}

	
	public void helper(int r, List<List<String>> ans, List<String> v, int n) {
		//base case
		//if all rows are filled it means it is a valid configuration then add this list into ans arraylist
		if(r == n) {
			ans.add(new ArrayList<>(v));
			return;
		}
		
		for(int c=0; c<n; c++) {
			//if it not a valid cell to place a queen then return false.
			if(check(r, c, v, n) == false) continue;
			//convert current string present at r index into char array
			//place Q at char[c] & then add this char array (after converting it into string) 
			//to list 'v' at r index
			char[] row = v.get(r).toCharArray();
			row[c] = 'Q';
			v.set(r, new String(row));
			//visit the next row to place a 'Q' queen
			helper(r+1, ans, v, n);
			//After storing one possible ans or current row combination is not possible due to any previous
			//queen placed at some wrong row & col, then convert the current column of char array to .(empty space)
			row[c] = '.';
			//then set this char array to list 'v' at index r
			v.set(r, new String(row));
		}
	}
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<>();
		String emptyRow = ".".repeat(n); //emptyRow -> "...." when n=4
		List<String> list = new ArrayList<>();
		//fill this list 
		for(int i=0; i <n; i++) {
			list.add(emptyRow);
		}
		//list -> [...., ...., ...., ....]
		//pass 0th row, ans, list, total no. of queens to place
		helper(0, ans, list, n);
		return ans;
    }

}
