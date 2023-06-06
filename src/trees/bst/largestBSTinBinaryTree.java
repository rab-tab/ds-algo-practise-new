package trees.bst;

import trees.Node;

public class largestBSTinBinaryTree {
    static int max = Integer.MIN_VALUE;
    static int ans = 0;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.left.left = new Node(0);
        root.left.right = new Node(5);
        int sol = solve(root);
        System.out.println(sol);
    }

    private static int solve(Node root) {
        if (root == null) return 0;
        if (isValidBST(root)) {
            System.out.println("size is " + ans);
            max = Math.max(ans, max);
        }

        int leftAns = solve(root.left);
        int rightAns = solve(root.right);
        ans = 1 + leftAns + rightAns;
        return ans;
    }

    private static boolean isValidBST(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.data > root.left.data && root.data < root.right.data) {
            // boolean leftAns=false;
            //boolean rightAns=false;
            boolean leftAns = isValidBST(root.left);
            boolean rightAns = isValidBST(root.right);
            if (leftAns && rightAns) {
                return true;
            } else
                return false;
        }
        return false;
    }
}
