package trees.bst;

import trees.Node;

public class minValue {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        System.out.println("Minimum value is " +solve(root));
    }

    private static int solve(Node root) {
        //approach 1 - inorder - 1st elem
        if (root.left == null && root.right == null) return root.data;
        if (root == null) return 0;
        return solve(root.left);
    }
}
