package trees.bst;

import trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class inorderToBST {
    public static void main(String[] args) {
      //  int arr[] = {10, 20, 30, 40, 50, 60, 70, 80};
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8,9};
        int start = 0;
        int end = arr.length - 1;
        Node root = solve(arr, start, end);
        traverse(root);
    }

    private static Node solve(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        //left part
        root.left = solve(arr, start, mid - 1);
        root.right = solve(arr, mid + 1, end);
        return root;

    }

    private static void traverse(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            System.out.println(temp.data);
            q.remove();

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);

        }
    }

}