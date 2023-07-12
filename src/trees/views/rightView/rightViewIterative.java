package trees.views.rightView;

import trees.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class rightViewIterative {
    public static void main(String[] args) {
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

        while (!q.isEmpty()) {

            // get number of nodes for each level
            int n = q.size();

            // traverse all the nodes of the current level
            for (int i = 0; i < n; i++) {
                Node curr = q.peek();
                q.remove();

                // print the last node of each level
                if (i == n - 1) {
                    System.out.print(curr.data);
                    System.out.print(" ");
                }

                // if left child is not null add it into
                // the
                // queue
                if (curr.left != null) {
                    q.add(curr.left);
                }

                // if right child is not null add it into
                // the
                // queue
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
}

