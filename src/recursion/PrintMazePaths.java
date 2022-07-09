package recursion;

public class PrintMazePaths {
    static int rWays = 0;
    static int dWays = 0;
    static int totalWays = 0;

    public static void main(String[] args) {
        int n = 3;
        int[][] maze = new int[n][n];
        mazePaths(maze, n, 1, 1, "");


    }

    public static void mazePaths(int[][] maze, int n, int currRow, int currCol, String ans) {

        if (currRow == n && currCol == n) {
            System.out.println(ans);
            return;
        }
        if (currCol < n) {
            mazePaths(maze, n, currRow, currCol + 1, ans + "r-");

        }
        if (currRow < n) {
            mazePaths(maze, n, currRow + 1, currCol, ans + "d-");
        }

    }
}
