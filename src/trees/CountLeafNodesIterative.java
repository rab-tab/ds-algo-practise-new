package trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountLeafNodesIterative {

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
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.add(root);
        while (!q.isEmpty()) {

            Node temp = q.peek();
            q.remove();
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
            if (temp.left == null && temp.right == null) count++;

        }
        return count;


    }
}
