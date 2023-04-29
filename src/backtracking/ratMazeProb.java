package backtracking;

public class ratMazeProb {
    static int drow[] = {1, 0, 0, -1};
    static int dcol[] = {0, -1, 1, 0};
    static char direction[] = {'D', 'L', 'R', 'U'};

    public static void main(String[] args) {


        int arr[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        int rows = 4;
        int cols = 4;
        boolean visited[][] = new boolean[rows][cols];
        visited[0][0] = true;
        ratMazeSolve(arr, visited, new StringBuilder(""), 0, 0, 4, 4);
    }


    public static void ratMazeSolve(int[][] arr, boolean[][] visited, StringBuilder sb, int currRow, int currCol,
                                    int totalRows, int totalCols) {

        //all four directions allowed
        if (arr[0][0] == 0) return;
        if (currRow == totalRows - 1 && currCol == totalCols - 1) {
            //print ans
            System.out.println(sb.toString());
            sb.setLength(0);
            return;
        }

        //alternate code
      /*  for (int k = 0; k < 4; k++) {
            int newRow = currRow + drow[k];
            int newCol = currCol + dcol[k];
            char dir = direction[k];
            if (isSafe(arr, visited, newRow, newCol, totalRows, totalCols)) {
                visited[newRow][newCol] = true;
                ratMazeSolve(arr, visited, sb.append("R"), newRow, newCol, totalRows, totalCols);
                visited[newRow][newCol] = false;
            }
        }*/


        //move in right direction and see if its safe
        if (isSafe(arr, visited, currRow, currCol + 1, totalRows, totalCols)) {
            visited[currRow][currCol + 1] = true;
            ratMazeSolve(arr, visited, sb.append("R"), currRow, currCol + 1, totalRows, totalCols);
            visited[currRow][currCol + 1] = false;

        }

        //move in left direction and see if its safe
        if (isSafe(arr, visited, currRow, currCol - 1, totalRows, totalCols)) {
            visited[currRow][currCol - 1] = true;
            ratMazeSolve(arr, visited, sb.append("L"), currRow, currCol - 1, totalRows, totalCols);
            visited[currRow][currCol - 1] = false;

        }
        //move in up direction and see if its safe
        if (isSafe(arr, visited, currRow - 1, currCol, totalRows, totalCols)) {
            visited[currRow - 1][currCol] = true;
            ratMazeSolve(arr, visited, sb.append("U"), currRow - 1, currCol, totalRows, totalCols);
            visited[currRow - 1][currCol] = false;

        }

        //move in down direction and see if its safe
        if (isSafe(arr, visited, currRow + 1, currCol, totalRows, totalCols)) {
            visited[currRow + 1][currCol] = true;
            ratMazeSolve(arr, visited, sb.append("D"), currRow + 1, currCol, totalRows, totalCols);
            visited[currRow + 1][currCol] = false;

        }

        return;
    }

    private static boolean isSafe(int[][] arr, boolean[][] visited, int currRow, int currCol, int totalRows, int totalCols) {
        //System.out.println("row " +currRow + "col -- visited "+ currCol + visited[currRow][currCol]);
        if (currRow >= 0 && currRow < totalRows &&
                currCol >= 0 && currCol < totalCols
                && visited[currRow][currCol] == false &&
                arr[currRow][currCol] == 1) return true;
        return false;
    }
}
