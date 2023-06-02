package trees.views;

import trees.Node;

public class boundaryView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(10);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        solve(root);
    }

    private static void solve(Node root) {
        if (root == null) return;
        System.out.println("Left nodes-----");
        printLeftNodes(root);
        System.out.println("Leaf nodes-----");
        printLeafNodes(root);
        System.out.println("right nodes-----");
        printRightNodes(root);

    }

    static void printLeftNodes(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        System.out.println(root.data);
        if (root.left != null) {
            printLeftNodes(root.left);
        } else
            printRightNodes(root.right);

    }

    private static void printLeafNodes(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) System.out.println(root.data);

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    private static void printRightNodes(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.right != null) {
            printRightNodes(root.right);
        } else
            printRightNodes(root.left);
        System.out.println(root.data);
    }


}
