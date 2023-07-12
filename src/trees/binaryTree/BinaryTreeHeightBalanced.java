package trees.binaryTree;

import trees.Node;

public class BinaryTreeHeightBalanced {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        System.out.println("Is height balanced " + isHeightBalanced(root));
    }


    public static boolean isHeightBalanced(Node root) {
        if (root == null) return true;
        int lHeight = BinaryTreeHeight.height(root.left);
        int rHeight = BinaryTreeHeight.height(root.right);

        if (Math.abs(lHeight - rHeight) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right))
            return true;
        return false;
    }
}
