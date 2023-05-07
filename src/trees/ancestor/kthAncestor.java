package trees.ancestor;

import trees.Node;

public class kthAncestor {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(80);
        root.left.right.left.left = new Node(110);
        root.left.right.left.right = new Node(120);
        root.left.left.left = new Node(70);
        root.right.right = new Node(60);
        root.right.right.left = new Node(90);
        root.right.right.right = new Node(100);
        System.out.println(solve(root, root.left.right.left.right, 2));
    }

    private static boolean solve(Node root, Node p, int k) {
        if (root == null) return false;
        //check if node is p
        if (root.data == p.data) return true;

        boolean leftAns = solve(root.left, p, k);
        boolean rightAns = solve(root.right, p, k);
        if (leftAns == true || rightAns == true) {
            k--;
        }
        if (k == 0) {
            System.out.println(root.data);
            k = -1;
        }
        return leftAns || rightAns;

    }
}
