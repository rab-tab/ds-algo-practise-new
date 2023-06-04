package trees.bst;

import trees.Node;

public class inorderPredecessor {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        //int elem = root.right.data; //150 expected ans : 125
        int elem = root.left.data;// 50 - expected ans : 25
        System.out.println(" inorderPredecessor " + solve(root, elem));
    }

    private static int solve(Node root, int elem) {
        // 25  ,50 ,75 , 100, 125,150 ,200
        if (root == null) return -1;
        if (root.data == elem) {
            ///logic to find predecessor
            //find max in left subtree
            //max can be found in right most part of left subtree
            //check if left subtree is not empty
            if (root.left != null) {
                return findMax(root.left, elem);
            }
        }
        // if the given key is less than the root node, recur for the left subtree
        else if (elem < root.data) {
            return solve(root.left, elem);
        }
        // if the given key is greater than the root node, recur for the right subtree
        else return solve(root.right, elem);
        return -1;

    }

    private static int findMax(Node root, int elem) {
        if (root.left == null && root.right == null) return root.data;
        if (root == null) return 0;
        return findMax(root.right, elem);
    }
}
