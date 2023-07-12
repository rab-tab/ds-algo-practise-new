package trees.binaryTree;

import trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class maximumWidthBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        System.out.println("Maximum width is " + maxiMumWidth(root));


    }


    public static int maxiMumWidth(Node root) {
        if (root == null) return 0;
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count=0;
        while (!q.isEmpty()) {
             count = q.size();
            result = Math.max(count, result);
            while (count > 0) {
                System.out.println("queue size is "+q.size());
                Node temp = q.peek();
                q.remove();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                count--;

            }

        }
        return result;


    }
}

