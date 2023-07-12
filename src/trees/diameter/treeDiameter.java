package trees.diameter;

import trees.Node;

public class treeDiameter {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(50);
        root.right.right = new Node(60);
        root.right.right.right = new Node(70);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        System.out.println("diameter is " + solve(root));
    }

    private static int solveHeight(Node root) {
        if (root == null) return 0;
        int lHeight = solveHeight(root.left);
        int rHeight = solveHeight(root.right);
        int height = Math.max(lHeight, rHeight) + 1;
        return height;
    }

    private static int solve(Node root) {
        if (root == null) return 0;
        int lDiameter = solve(root.left);
        int rDiameter = solve(root.right);
        int inclRootDiameter = 1 + solveHeight(root.left) + solveHeight(root.right);
        return Math.max(Math.max(lDiameter, rDiameter), inclRootDiameter);

    }


}
