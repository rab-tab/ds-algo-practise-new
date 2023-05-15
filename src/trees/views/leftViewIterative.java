package trees.views;

import trees.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class leftViewIterative {
    public static void main(String[] args) {
       /* Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(80);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.left.right.left = new Node(60);
        root.right.left = new Node(50);
        root.right.left.right = new Node(70);
        root.right.right = new Node(90);*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Map<Integer, Integer> map = new HashMap<>();
        solve(root, map);
    }

    private static void solve(Node root, Map<Integer, Integer> map) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.peek();

            if (temp != null) {

                // Prints first node
                // of each level
                System.out.print(temp.data + " ");

                // add children of all nodes at
                // current level
                while (q.peek() != null) {

                    // If left child is present
                    // add into queue
                    if (temp.left != null)
                        q.add(temp.left);

                    // If right child is present
                    // add into queue
                    if (temp.right != null)
                        q.add(temp.right);

                    // remove the current node
                    q.remove();

                    temp = q.peek();
                }

                // add delimiter
                // for the next level
                q.add(null);
            }

            // remove the delimiter of
            // the previous level
            q.remove();
        }
    }
}
