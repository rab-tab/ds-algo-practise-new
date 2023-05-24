package trees.bst;

import trees.Node;

public class bstToSortedDLL {
    static Node head=null;
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(20);
        root.left.right = new Node(60);
        root.left.right.left = new Node(55);
        root.right = new Node(200);
        root.right.left = new Node(150);
        root.right.left.right = new Node(170);
        root.right.right = new Node(250);
        root.right.right.right = new Node(300);
        convertIntoSortedDLL(root);
        printLinkedList();

    }

    public static void convertIntoSortedDLL(Node root) {
        if (root == null) return;
        //convert right subtree into LL
        convertIntoSortedDLL(root.right);

        //attach root node
        root.right = head;
        if (head != null) head.left = root;

        head = root;

        convertIntoSortedDLL(root.left);

    }

    public static void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.right;
        }
    }
}
