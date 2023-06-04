package trees.bst;

import trees.Node;

//IMP
public class BSTDeletion {
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right = new Node(150);
        root.right.left = new Node(125);
        root.right.right = new Node(200);
        int elem = root.left.data;
        deleteNodeInBST(root, elem);
    }

    private static Node deleteNodeInBST(Node root, int elem) {
        //cases :
        //case 1 : no children of elem
        //case 2 : left -null , right - non null
        //case 3:  right - null , left -non null
        //case 4 : both child exists : replace elem with inorder predecessor or inorder successor

        if (root == null) return root;
        Node temp = findNodeInBST(root, elem);

        //case 1 : no children of elem
        if (root.left == null && root.right == null) {
            root = null;
            return null;
        }

        //case 2 : left -null , right - non null
        else if (root.left == null && root.right != null) {
            Node child = temp.right;
            temp = null;
            return child;
        }

        //case 3:  right - null , left -non null
        else if (root.left != null && root.right == null) {
            Node child = temp.left;
            temp = null;
            return child;
        }
        //case 4 : both child exists : replace elem with inorder predecessor or inorder successor
        else {
            int inorderPredecessor = inorderPredecessor(temp, elem);
            temp.data = inorderPredecessor;
            return deleteNodeInBST(temp.left, inorderPredecessor);
        }
    }


    private static Node findNodeInBST(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        if (target > root.data) return findNodeInBST(root.right, target);
        else return findNodeInBST(root.left, target);
    }

    private static int inorderPredecessor(Node root, int elem) {
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
            return inorderPredecessor(root.left, elem);
        }
        // if the given key is greater than the root node, recur for the right subtree
        else return inorderPredecessor(root.right, elem);
        return -1;

    }

    private static int findMax(Node root, int elem) {
        if (root.left == null && root.right == null) return root.data;
        if (root == null) return 0;
        return findMax(root.right, elem);
    }
}
