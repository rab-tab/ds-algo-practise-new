package backtracking;

public class permutations {
    public static void main(String[] args) {
        int nboxes = 4;
        int rItems = 2;
        permutations(new int[nboxes], 1, rItems);
    }

    public static void permutations(int[] boxes, int currItem, int totalItems) {

        if (currItem > totalItems) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.println(boxes[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currItem;
                permutations(boxes, currItem + 1, totalItems);
                boxes[i] = 0;
            }
        }

    }
}
