package backtracking;

public class queensPemutation {
    public static void main(String[] args) {
        int n = 3;
        int[][] chess = new int[n][n];
        queensPermutations(0, chess, n);

    }


    public static void queensPermutations(int queensPlaced, int[][] chess, int totalQueens) {

        if (totalQueens == queensPlaced) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] == 0) {
                        System.out.println("-\t");

                    } else {
                        System.out.println("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] == 0) {
                    //place queen
                    chess[i][j] = queensPlaced + 1;
                    queensPermutations(queensPlaced + 1, chess, totalQueens);

                }
            }
        }

    }
}
