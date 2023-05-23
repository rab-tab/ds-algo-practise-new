package trees.bst;

import trees.Node;

public class validateBST {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(Node root) {
        int lowerBound = Integer.MIN_VALUE;
        int upperBound = Integer.MAX_VALUE;
        return solve(root, lowerBound, upperBound);
    }

    private static boolean solve(Node root, int lowerBound, int upperBound) {
        if (root == null) return true;
        if (root.data > lowerBound && root.data < upperBound) {
            boolean leftAns = solve(root.left, lowerBound, root.data);
            boolean rightAns = solve(root.right, root.data, upperBound);
            return leftAns && rightAns;
        } else return false;

    }
}
