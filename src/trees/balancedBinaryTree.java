package trees;

public class balancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        System.out.println("Is balanced--- " + isBalanced(root));
    }

    private static boolean isBalanced(Node root) {
        if (root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        int diff = Math.abs(lh - rh);

        boolean ans = (diff <= 1);

        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);

        if (ans && leftAns && rightAns) return true;
        else return false;

    }

    private static int height(Node root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }

}
