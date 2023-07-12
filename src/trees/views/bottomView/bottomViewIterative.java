package trees.views.bottomView;

import trees.Node;
import trees.views.Pair;

import java.util.*;

public class bottomViewIterative {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right = new Node(8);
        Map<Integer, Integer> map = new HashMap<>();
        solve(root, map);

    }

    private static void solve(Node root, Map<Integer, Integer> map) {
        Queue<Pair<Integer, Node>> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.peek();
            q.remove();

            Node node = temp.node;
            int dist = temp.dist;

            map.put(dist, node.data);
            if (node.left != null) q.add(new Pair<>(node.left, dist - 1));
            if (node.right != null) q.add(new Pair<>(node.right, dist + 1));

        }

        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        sorted.putAll(map);
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", " + "Value= " + entry.getValue());

        }


    }
}
