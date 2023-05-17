package trees.bst;

import trees.Node;

public class kthSmallest {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(20);
        root.left.right = new Node(60);
        root.left.right.left = new Node(55);
        root.right = new Node(200);
        root.right.left = new Node(150);
        root.right.left.right = new Node(170);
        root.right.right = new Node(250);
        root.right.right.right = new Node(300);
        int k = 1;
        System.out.println(solve(root, k));
    }

    private static int solve(Node root, int k) {
        if (root == null) return -1;
        int leftAns = solve(root.left, k);
        if (leftAns != -1) return leftAns;
        k--;
        if (k == 0) return root.data;
        int rightAns = solve(root.right, k);
        return rightAns;

    }

}
