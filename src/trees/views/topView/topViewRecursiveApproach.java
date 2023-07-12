package trees.views.topView;

import trees.Node;

import java.util.HashMap;
import java.util.Map;

public class topViewRecursiveApproach {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        int dist = 0;
        solve(root, dist);
        printTopView(map);

    }

    private static void printTopView(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            System.out.println(mp.getValue());
        }
    }

    private static void solve(Node root, int dist) {

        if (root == null) return;
        if (!map.containsKey(dist)) {
            map.put(dist, root.data);
        }
        solve(root.left, dist - 1);
        solve(root.right, dist + 1);

    }

}
