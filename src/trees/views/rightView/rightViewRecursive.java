package trees.views.rightView;

import trees.Node;

import java.util.HashMap;
import java.util.Map;

public class rightViewRecursive {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(10);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        int level = 0;
        solve(root, level);
        printRightView();
    }


    private static void printRightView() {
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            System.out.println(mp.getValue());
        }
    }

    private static void solve(Node root, int level) {
        if (root == null) return;
        if (!map.containsKey(level)) map.put(level, root.data);
        solve(root.right, level + 1);
        solve(root.left, level + 1);


    }
}
