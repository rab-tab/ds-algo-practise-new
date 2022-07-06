package recursion;

public class floodFill {
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 1},
                {0, 0, 1},
                {1, 0, 0},
                {0, 1, 0}};
        boolean[][] visited=new boolean[arr.length][arr[0].length];
        solve(arr, 0, 0, "",visited);

    }


    public static void solve(int[][] maze, int currRow, int currCol, String ans,boolean[][] visited) {
        if (currRow < 0 || currCol < 0 || currRow == maze.length || currCol == maze[0].length ||
                maze[currRow][currCol] == 1 || visited[currRow][currCol]==true) {
            return;
        }
        if (currRow == maze.length - 1 && currCol == maze[0].length - 1) {
            System.out.println(ans);
            return;
        }
        visited[currRow][currCol]=true;
        solve(maze, currRow, currCol + 1, ans + "r",visited);
        solve(maze, currRow, currCol - 1, ans + "l",visited);
        solve(maze, currRow - 1, currCol, ans + "t",visited);
        solve(maze, currRow + 1, currCol, ans + "d",visited);
        visited[currRow][currCol]=false;

    }
}
