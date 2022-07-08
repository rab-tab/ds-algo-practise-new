package backtracking;

public class BoxCombinations {
    public static void main(String[] args) {
        int boxes = 4;
        int items = 2;
        combinations(1, boxes, 0, items, "");
    }

    private static void combinations(int currBox, int boxes, int ssf, int items, String ans) {
        if(currBox>boxes) {
            if (ssf == items) {
                System.out.println(ans);

            }
            return;
        }
        combinations(currBox + 1, boxes, ssf + 1, items, ans + "i");
        combinations(currBox + 1, boxes, ssf, items, ans + " - ");
    }
}
