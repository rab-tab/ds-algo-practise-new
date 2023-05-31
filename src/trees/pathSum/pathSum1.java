package trees.pathSum;

import trees.Node;

public class pathSum1 {
    public static void main(String[] args) {
       /* Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(1);
        int targetSum = 8;*/
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(2);
        int currSum = 0;
        int targetSum = 10;
        solve(root, targetSum, currSum, "");
    }

    private static void solve(Node root, int targetSum, int currSum, String ans) {

        if (root == null) return;
        if (root.left == null && root.right == null) {
            currSum = currSum + root.data;
            ans = ans + "-- " + root.data;
            if (targetSum == currSum) {
                System.out.println(ans);
                ans = " ";
                return;
            }
        }
        solve(root.left, targetSum, currSum + root.data, ans + "-- " + root.data);
        solve(root.right, targetSum, currSum + root.data, ans + "-- " + root.data);

    }
}
