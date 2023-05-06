package backtracking;

public class queens {
    public static void main(String[] args) {
        int n = 4;
        int[][] chessBoard = new int[n][n];
        solve(chessBoard, n, 0);
    }

    private static void solve(int[][] chessBoard, int n, int col) {
        if (col >= n) {
            printSolution(chessBoard, n);
            System.out.println("-----------------------------");
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(chessBoard, n, row, col)) {
                chessBoard[row][col] = 1;
                solve(chessBoard, n, col + 1);
                chessBoard[row][col] = 0;
            }
        }
    }

    private static void printSolution(int[][] chessBoard, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chessBoard[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] chessBoard, int n, int row, int col) {
        int i = row;
        int j = col;
        while (j >= 0) {
            if (chessBoard[i][j] == 1) return false;
            j--;
        }

        //upper left diagonal

        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 1) return false;
            i--;
            j--;

        }

        //lower left diagonal
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (chessBoard[i][j] == 1) return false;
            i++;
            j--;
        }
        return true;
    }
}
