package backtracking;

public class queensCombination {
    public static void main(String[] args) {
        int totalQueens = 3;
        int row = 3;
        int col = 3;
        solve(0, totalQueens, 0, 0, "");
    }

    public static void solve(int queensPlaced, int totalQueens, int row, int col, String ans) {
        if (row == totalQueens) {
            if(queensPlaced==totalQueens) {
                System.out.println(ans);
            }
            return;
        }
        if (col == totalQueens - 1) // move to new row
        {
            row = row + 1;
            col = 0;
          //  System.out.println();
        } else {
            col = col + 1;
        }

        solve(queensPlaced, totalQueens, row, col, ans+"-");
        solve(queensPlaced + 1, totalQueens, row, col, ans + "q");


    }
}
