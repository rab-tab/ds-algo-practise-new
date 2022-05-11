package backtracking;

public class ratMazeProb {
    public static void main(String[] args) {
        int arr[][] = {{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1,}};
        int rows = 4;
        int cols = 4;
        int visited[][] = new int[rows][cols];
        ratMazeSolve(arr, visited, new StringBuilder(""), 0, 0, 4, 4);

    }


    public static void ratMazeSolve(int[][] arr, int[][] visited, StringBuilder sb, int currRow, int currCol,
                                    int totalRows, int totalCols) {

        // D , R , L ,U
        //start at 0,0
        // move in downward direction
        // check if not visited
        // check if not out of bounds
        //mark visited[0][0] as 1
        // add 'D' direction in list

        //base case
        if (currCol == totalCols && currRow == totalRows) {
            System.out.println("One route is " + sb.toString());
            return;
        }
        visited[currRow][currCol] = 1;
        //Down
        if (isSafe(currRow + 1, currCol, totalRows, totalCols, visited, arr)) {
            ratMazeSolve(arr, visited, sb.append("D"), currRow + 1, currCol, totalRows, totalCols);

        }
        //left

        if (isSafe(currRow, currCol - 1, totalRows, totalCols, visited, arr)) {
            ratMazeSolve(arr, visited, sb.append("L"), currRow, currCol - 1, totalRows, totalCols);


        }
        //right
        if (isSafe(currRow, currCol + 1, totalRows, totalCols, visited, arr)) {
            ratMazeSolve(arr, visited, sb.append("R"), currRow, currCol + 1, totalRows, totalCols);

        }

        //up
        if (isSafe(currRow - 1, currCol, totalRows, totalCols, visited, arr)) {
            ratMazeSolve(arr, visited, sb.append("U"), currRow - 1, currCol, totalRows, totalCols);

        }
        visited[currRow][currCol] = 0;
    }


    public static boolean isSafe(int currRow, int currCol, int totalRows, int totalCols, int[][] visited, int arr[][]) {
        if ((currRow >= 0 && currRow < totalRows) &&
                (currCol >= 0 && currCol < totalCols) &&
                visited[currRow][currCol] != 1 &&
                arr[currRow][currCol] == 1)
            return true;
        return false;

    }
}
