package trees.bst;

import trees.Node;

import java.util.ArrayList;
import java.util.List;

public class targetSum {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        System.out.println(findTarget(root, 160));

    }

    public static boolean findTarget(Node root, int k) {
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root, inorder);
        int start = 0;
        int end = inorder.size()-1;
        while (start < end) {
            int sum = inorder.get(start) + inorder.get(end);
            if (sum == k) return true;
            if (sum > k) end = end - 1;
            else start = start + 1;
        }
        return false;
    }

    private static void storeInorder(Node root, List<Integer> inorder) {
        if (root == null) return;
        storeInorder(root.left, inorder);
        inorder.add(root.data);
        storeInorder(root.right, inorder);
    }
}
