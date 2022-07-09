package recursion;

public class MazePaths {
    static int rWays = 0;
    static int dWays = 0;
    static int totalWays=0;
    public static void main(String[] args) {
        int n = 3;
        int[][] maze = new int[n][n];
        int k = mazePaths(maze, n, 1, 1);
        System.out.println(k);

    }

    public static int mazePaths(int[][] maze, int n, int currRow, int currCol) {

        if (currRow==n && currCol ==n) return 1;
        if (currCol < n ) {
            rWays = mazePaths(maze, n, currRow, currCol +1);
        }
        if (currRow < n) {
            dWays = mazePaths(maze, n, currRow +1, currCol);
        }
        totalWays = rWays + dWays;
        return totalWays;
    }
}
