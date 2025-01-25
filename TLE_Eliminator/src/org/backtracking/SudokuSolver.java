package org.recursion;

//Hard question on backtracking
public class SudokuSolver {
	
	private static boolean check(char[][] board, int r, int c, char ch) {
        // check for duplicate values(for all cols) in a current row
        for (int col = 0; col < 9; col++) {
            if (board[r][col] == ch)
                return false;
        }
        // check for duplicate values(for all rows) in a current col
        for (int row = 0; row < 9; row++) {
            if (board[row][c] == ch)
                return false;
        }

        // check into 3*3 grid
        // find coordinate of first row of that grid
        int r1 = r - (r % 3);
        // find coordinate of first col of that grid
        int c1 = c - (c % 3);
        // traverse into that grid
        for (int i = r1; i < r1 + 3; i++) {
            for (int j = c1; j < c1 + 3; j++) {
                if (board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }

    private static boolean helper(char[][] board, int r, int c) {
        // base cases
        // rows are exhausted, our sudoku is solved
        if (r == 9) {
            // board has finished
            return true;
        }
        // cols are exhausted
        if (c == 9) {
            // change the row & go to column 0 because all columns are traversed for the
            // current row
            // always traverse left to right
            return helper(board, r + 1, 0);
        }
        // if current cell is not empty then move ahead to the next cell
        if (board[r][c] != '.') {
            return helper(board, r, c + 1);
        }

        // move forward for all possible values of a grid (from 1 to 9)
        for (char ch = '1'; ch <= '9'; ch++) {
            // check whethere a current move is valid or not according to sudoku rules.
            if (check(board, r, c, ch) == false)
                continue;
            // if current move is valid then fill(populate) the grid with curr ch
            board[r][c] = ch;
            // move to next column
            boolean ans = helper(board, r, c + 1);
            if (ans == true) {
                return true;
            }
            // if ans is false then backtrack & before going back one level up,
            // make current modified grid to its original value i.e. (.) empty cell
            board[r][c] = '.';
        }
        // if it is retuned for first row & first col then this sudoku can not be
        // solved. In question
        // it is given that input board has only one solution, this case will never
        // occure
        return false;
    }

    public static void solveSudoku(char[][] board) {
        boolean ans = helper(board, 0, 0);
    }

}
