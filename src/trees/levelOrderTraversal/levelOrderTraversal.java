package trees.levelOrderTraversal;

import trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        traverse(root);
    }

    private static void traverse(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            System.out.println(temp.data);
            q.remove();

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);

        }

    }


}
