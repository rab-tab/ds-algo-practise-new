package trees.views;

import trees.Node;

import java.util.*;

public class topView {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(80);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.left.right.left = new Node(60);
        root.right.left = new Node(50);
        root.right.left.right = new Node(70);
        root.right.right = new Node(90);
        Map<Integer, Integer> map = new HashMap<>();
        solve(root, map);
    }

    private static void solve(Node root, Map<Integer, Integer> map) {
        if (root == null) return;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.peek();
            q.remove();

            Node currNode = temp.node;
            Integer dist = temp.dist;

            if (!map.containsKey(dist)) {
                System.out.println("putting " + currNode.data + " in map");
                map.put(dist, currNode.data);
            }

            if (currNode.left != null) {
                q.add(new Pair(currNode.left, dist - 1));
            }
            if (currNode.right != null)
                q.add(new Pair(currNode.right, dist + 1));

        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        sorted.putAll(map);

        for (Map.Entry<Integer, Integer> entry : sorted.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
