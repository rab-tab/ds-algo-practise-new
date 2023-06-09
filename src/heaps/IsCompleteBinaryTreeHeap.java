package heaps;

import trees.Node;
import heaps.Pair;

public class IsCompleteBinaryTreeHeap {
    //heap property - 1) should be complete binary tree
    // 2) heap property - min or max heap
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(2);
        Pair<Boolean, Integer> sol = solve(root);
        System.out.println("is complete binary tree a heap --" + sol.ans);

    }

    static Pair<Boolean, Integer> solve(Node root) {
        if (root == null) return new Pair(true, Integer.MIN_VALUE);
        if (root.left == null && root.right == null) return new Pair(true, root.data);
        Pair<Boolean, Integer> leftAns = solve(root.left);
        Pair<Boolean, Integer> rightAns = solve(root.right);

        if (leftAns.ans == true && rightAns.ans == true &&
                root.data > leftAns.data && root.data > rightAns.data) return new Pair<>(true, root.data);
        else return new Pair<>(false, root.data);

    }
}
