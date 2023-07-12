package trees.ancestor;

import trees.Node;

public class lca {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("LCA is " + lca(root, 10, 4));

    }

    public static int lca(Node root, int n1, int n2) {
        while (root != null) {
            if (n1 < root.data && n2 < root.data) {
                root = root.left;
            } else if (n1 > root.data && n2 > root.data) {
                root = root.right;
            } else break;
        }
        return root.data;
    }
}
