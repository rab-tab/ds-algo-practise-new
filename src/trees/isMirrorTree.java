package trees;

public class isMirrorTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println("Is tree symmetric--- "+ isSymmetric(root));
    }

    private static boolean isSymmetric(Node root) {

        if (root == null) return true;
        return checkMirror(root.left, root.right);
    }

    private static boolean checkMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1.data != root2.data) return false;
        boolean op1 = checkMirror(root1.left, root2.right);
        boolean op2 = checkMirror(root1.right, root2.left);
        return (op1 && op2);
    }
}
