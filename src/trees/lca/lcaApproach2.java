package trees.lca;

import trees.Node;

public class lcaApproach2 {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node ans= lca(root,  root.left.right.left, root.left.left);
        System.out.println("LCA is " + ans.data);

    }

    public static Node lca(Node root, Node node1, Node node2) {
        if (root == null) return null;
        //check if node is node1 /node2
        if (root.data == node1.data) return node1;
        if (root.data == node1.data) return node2;

        Node leftAns = lca(root.left, node1, node2);
        Node rightAns = lca(root.right, node1, node2);

        if (leftAns == null && rightAns == null) return null;
        else if (leftAns != null && rightAns == null) return leftAns;
        else if (leftAns == null && rightAns != null) return rightAns;
        else return root;


    }

}
