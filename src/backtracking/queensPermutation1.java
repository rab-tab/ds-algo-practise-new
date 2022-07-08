package backtracking;

public class queensPermutation1 {
    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        queensPermutation(n, 0, chess);

    }

    public static void queensPermutation(int totalQueens, int queensPlaced, int[][] chess) {
        if (queensPlaced == totalQueens) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] == 0) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                    System.out.println();

                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] == 0) {
                    chess[i][j] = queensPlaced + 1;
                    queensPermutation(totalQueens, queensPlaced + 1, chess);
                    chess[i][j] = 0;
                }
            }
        }

    }


}
