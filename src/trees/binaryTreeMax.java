package trees;

public class binaryTreeMax {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int max = findMax(root);
        System.out.println("Binary tree height is --- " + max);

    }

    public static int findMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int res = root.data;
        int lres = findMax(root.left);
        int rres = findMax(root.right);
        return Math.max(Math.max(res, lres), rres);

    }


}
