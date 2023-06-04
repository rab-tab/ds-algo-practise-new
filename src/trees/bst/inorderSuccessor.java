package trees.bst;

import trees.Node;

public class inorderSuccessor {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        // 25  ,50 ,75 , 100, 125,150 ,200
        int elem = root.left.data;// 100 - expected ans : 125
        int ans= solve(root, elem);
        if(ans==-1) System.out.println("No elem found");
        System.out.println(" inorderPredecessor " + ans);
    }

    private static int solve(Node root, int elem) {
        if (root == null) return -1;
        if (root.data == elem) {
            //find in  right subtree , min in right subtree would be the solution
            if (root.right != null) {
                return findMinRightSubtree(root.right, elem);
            }
        }
        // if the given key is less than the root node, recur for the left subtree
        else if (elem < root.data) return solve(root.left, elem);
        else return solve(root.right, elem);
        return -1;

    }

    private static int findMinRightSubtree(Node root, int elem) {
        if (root == null) return -1;
        if (root.right == null && root.left == null) return root.data;
        return findMinRightSubtree(root.left, elem);

    }
}
