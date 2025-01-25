package org.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen_Hard {

    private boolean isValid(int row, int col, List<String> board, int n) {
        // Check vertical direction
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solve(int row, List<List<String>> solutions, List<String> board, int n) {
    	//base case
        if (row == n) {
            solutions.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board, n) == false) continue;
            
            char[] rowArray = board.get(row).toCharArray();
            rowArray[col] = 'Q';
            board.set(row, new String(rowArray));

            solve(row + 1, solutions, board, n);

            rowArray[col] = '.';
            board.set(row, new String(rowArray));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String emptyRow = ".".repeat(n);

        for (int i = 0; i < n; i++) {
            board.add(emptyRow);
        }

        solve(0, solutions, board, n);
        return solutions;
    }
    
    public static void main(String[] args) {
    	//initially assign all cells to empty space for n*n chessboard
    	int n = 4;
    	List<String> list = new ArrayList<>();
    	String emptyRow = ".".repeat(n);
    	for(int i=0; i <n; i++) {
			list.add(emptyRow);
		}
    	
    	System.out.println(list);
	}
}
