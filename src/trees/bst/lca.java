package trees.bst;

import trees.Node;

public class lca {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        Node p = root.right.left; // 125
        Node q = root.left.right; // 75
        Node ans=solve(root, p, q);

         p = root.left; // 50
         q = root.left.left; // 25
         ans=solve(root, p, q);


        System.out.println("Lca is  "+ans.data);

    }

    private static Node solve(Node root, Node p, Node q) {
        if (root == null) return null;
        if (p.data < root.data && q.data < root.data) return solve(root.left, p, q);
        if (p.data > root.data && q.data > root.data) return solve(root.right, p, q);
        return root;
    }
}
