package trees.views;

import trees.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class verticalView {
    static Map<Integer, List<Integer>> map = new HashMap<>();

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
        printTopView();
    }

    private static void printTopView() {
        for (Map.Entry<Integer, List<Integer>> mp : map.entrySet()) {
            List<Integer> temp = mp.getValue();
            for (Integer i : temp) {
                System.out.print(i + " -- ");
            }
            System.out.println();
        }
    }

    private static void solve(Node root, int dist) {
        if (root == null) return;
        if (map.containsKey(dist)) {
            //Map.Entry<Integer, List<Integer>> mp = (Map.Entry<Integer, List<Integer>>) map.entrySet();
            System.out.println("root is "+root.data + " dist is "+dist);
            List<Integer> temp = map.get(dist);
            temp.add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(dist, list);
        }

        solve(root.left, dist - 1);
        solve(root.right, dist + 1);
    }
}
