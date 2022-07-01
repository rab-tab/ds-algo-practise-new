package trees;

public class isSubTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.right = new Node(30);
        Node root1 = new Node(26);
        root1.left = new Node(10);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(6);
        root1.left.left.right = new Node(30);
        System.out.println(isSubTree(root, root1));
    }

    public static boolean isSubTree(Node node1, Node node2) {

       if(node1==null ) return true;
       if(node2==null) return false;
        if (isIdentical(node1, node2)) return true;
        return isSubTree(node1.left, node2) || isSubTree(node1.right, node2);
    }

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));

    }
}
