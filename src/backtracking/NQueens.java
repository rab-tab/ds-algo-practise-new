package backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        int rows = 4;
        int cols = 4;
        int chess[][] = new int[rows][cols];
        printNQueens(chess, "", 0, n);

    }

    public static void printNQueens(int[][] chess, String ans, int col, int n) {
        if (col >= n) {
            printSolution(chess, n);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(chess, row, col, n)) {
                chess[row][col] = 1;
                printNQueens(chess, ans + "-" + row + "-" + col + ",", col + 1, n);
                chess[row][col] = 0;
            }
        }

    }

    private static void printSolution(int[][] chess, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] chess, int row, int col, int n) {
        //upper left diagnoal
        //bottom left diagonal
        //left row
        //vertical check
        int i = row;
        int j = col;

        //check row
        while (j >= 0) {
            if (chess[row][col] == 1) return false;
            j--;
        }

        //check upper left diagonal
        i = row;
        j = col;

        while (i >= 0 && j >= 0) {
            if (chess[row][col] == 1) return false;
            i--;
            j--;

        }
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (chess[row][col] == 1) return false;
            i++;
            j--;

        }


       /* //check bottom left diagonal
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[row][col] == 1) return false;
        }
        //diagnl check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[row][col] == 1) return false;
        }
        //diagnl check
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[row][col] == 1) return false;
        }*/
        return true;
    }
}
