package trees.ancestor;

import trees.Node;

public class Ancestors {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        printAncestors(root, 7);
    }

    public static boolean printAncestors(Node root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
            System.out.println(root.data);
            return true;
        }
        return false;


    }
}
