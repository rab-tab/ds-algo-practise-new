package trees.views.bottomView;

import trees.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class bottomViewRecursive {
    static Map<Integer, Integer> map = new HashMap<>();

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
        int dist = 0;
        solve(root, dist);
        printBottomView();
    }

    private static void printBottomView() {
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(map);
        for (Map.Entry<Integer, Integer> mp : sortedMap.entrySet()) {
            System.out.println(mp.getValue());
        }

    }

    private static void solve(Node root, int dist) {
        if (root == null) return;
        map.put(dist, root.data);
        solve(root.left, dist - 1);
        solve(root.right, dist + 1);

    }
}
