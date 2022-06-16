package trees;

public class MirrorTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.left = new Node(5);
        mirror(root);

    }

    public static void mirror(Node root) {
        if (root == null) return;
        Node temp;
        mirror(root.left);
        mirror(root.right);

        temp = root.left;
        root.left = root.right;
        root.right = temp;

    }


}
