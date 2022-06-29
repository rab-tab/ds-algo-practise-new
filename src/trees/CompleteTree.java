package trees;

public class CompleteTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(" Is complete binary tree " + isCompleteBinaryTree(root));
    }

    public static boolean isCompleteBinaryTree(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right != null) return false;
        isCompleteBinaryTree(root.left);
        isCompleteBinaryTree(root.right);
        return false;
    }

}
