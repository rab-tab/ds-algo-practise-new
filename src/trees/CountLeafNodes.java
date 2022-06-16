package trees;

public class CountLeafNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Total leaf nodes are --- " + leafNodes(root));


    }

    public static int leafNodes(Node root) {
        //base condition
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;

        return leafNodes(root.left) + leafNodes(root.right);


    }
}
