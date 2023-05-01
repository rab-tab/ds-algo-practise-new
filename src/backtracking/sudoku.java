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
        solve(grid, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean solve(int[][] grid, int n) {
        //cell should not be zero
        //for every row place 1-9 in each column and check if its safe
        //if yes place the number and continue
        //if no return
        // increase the row number and continue
       /* if (row < 0 || col < 0) return;
        if (row == grid.length - 1) {
            System.out.println(ans);
            return;
        }
        if (col == grid[0].length - 1) {
            row = row + 1;
            col = 0;
        } else {
            col = col + 1;
        }*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //check for empty cell
                if (grid[i][j] == 0) {
                    for (int value = 1; value <= 9; value++) {
                        if (isSafe(grid, i, j, value)) {
                            grid[i][j] = value;
                            boolean ans = solve(grid, n);
                            if (ans == true) return true;
                            grid[i][j] = 0;
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] grid, int i, int j, int value) {
        //same column
        for (int currRow = 0; currRow < grid.length; currRow++) {
            if (grid[currRow][j] == value) {
                //     System.out.println("same column contains " + data);
                return false;
            }
        }
        // same row
        for (int currCol = 0; currCol < grid.length; currCol++) {
            if (grid[i][currCol] == value) return false;
        }

        int subMatrixRow = i / 3 * 3;
        int subMatrixColumn = j / 3 * 3;


        //sub matrix
        for (int currRow = 0; currRow < 3; currRow++) {
            for (int currCol = 0; currCol < 3; currCol++) {
                if (grid[subMatrixRow + currRow][subMatrixColumn + currCol] == value) return false;
            }
        }

        return true;
    }

}

