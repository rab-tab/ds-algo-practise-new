package backtracking;

public class NQueens {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int chess[][] = new int[rows][cols];
        printNQueens(chess, "", 0);

    }

    public static void printNQueens(int[][] chess, String ans, int row) {
        if (row == chess.length) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (isSafe(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, ans + "-" + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }

    }

    public static boolean isSafe(int[][] chess, int row, int col) {
        //vertical check
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
        }
        return true;
    }
}
