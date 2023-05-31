package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderInorderTreeCreation {
    static int preOrderIdx=0;
    public static void main(String[] args) {
        int inOrder[] = {40, 20, 50, 10, 60, 30, 70};
        int preOrder[] = {10, 20, 40, 50, 30, 60, 70};
        Node root = solve(inOrder, preOrder, preOrder.length, 0, inOrder.length - 1);
        traverse(root);
    }

    private static Node solve(int[] inOrder, int[] preOrder,
                              int size ,int inorderStartIdx, int inOrderEndIdx) {
        if (preOrderIdx >= size || inorderStartIdx > inOrderEndIdx) return null;
        int elem = preOrder[preOrderIdx++];
        Node root = new Node(elem);
        int pos = findPosition(inOrder, elem, size);
        root.left = solve(inOrder, preOrder, size, inorderStartIdx, pos - 1);
        root.right = solve(inOrder, preOrder, size, pos + 1, inOrderEndIdx);
        return root;

    }


    static int findPosition(int arr[], int elem, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == elem) return i;
        }
        return -1;

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
