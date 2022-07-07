package backtracking;

public class sudoku {
    //does not repeat in row , cell , grid (submatrix)
    public static void main(String[] args) {

        int n = 9;
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solve(grid, 0, 0, n, "");

    }

    public static void solve(int[][] grid, int row, int col, int gridSize, String ans) {
        //cell should not be zero
        //for every row place 1-9 in each column and check if its safe
        //if yes place the number and continue
        //if no return
        // increase the row number and continue
        if (row < 0 || col < 0) return;
        if (row == grid.length-1) {
            System.out.println(ans);
            return;
        }
        if (col == grid[0].length-1) {
            row = row + 1;
            col = 0;
        } else {
            col = col + 1;
        }

        if (grid[row][col] != 0) {
            solve(grid, row, col, gridSize, ans);
        }
        for (int currCol = 1; currCol <= gridSize; currCol++) {
            if (isSafe(grid, row, col, currCol)) {
                grid[row][col] = col;
                solve(grid, row, col, gridSize, ans + "--" + currCol);
                grid[row][col] = 0;
            }
        }


    }

    private static boolean isSafe(int[][] grid, int row, int col, int data) {
        //same column
        for (int currRow = 0; currRow < grid.length; currRow++) {
            if (grid[currRow][col] == data) {
           //     System.out.println("same column contains " + data);
                return false;
            }
        }
        // same row
        for (int currCol = 0; currCol < grid.length; currCol++) {
            if (grid[row][currCol] == data) return false;
        }

        int subMatrixRow = row / 3 * 3;
        int subMatrixColumn = col / 3 * 3;


        //sub matrix
        for (int currRow = 0; currRow < 3; currRow++) {
            for (int currCol = 0; currCol < 3; currCol++) {
                if (grid[subMatrixRow + currRow][subMatrixColumn + currCol] == data) return false;
            }
        }

        return true;
    }

}

