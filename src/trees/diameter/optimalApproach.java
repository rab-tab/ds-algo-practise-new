package trees.diameter;

import trees.Node;

public class optimalApproach {
    static int diameter = 0;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(50);
        root.right.right = new Node(60);
        root.right.right.right = new Node(70);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        System.out.println("diameter is " + diameterBinaryTree(root));
    }

    private static int diameterBinaryTree(Node root) {
        height(root);
        return diameter;
    }

    private static int height(Node root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int currDiameter = lh + rh;
        diameter = Math.max(currDiameter, diameter);
        return lh + rh + 1;
    }
}
