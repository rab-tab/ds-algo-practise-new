package trees;

public class treeHeight {
    public static void main(String[] args) {
            Node root = new Node(3);
            root.left = new Node(2);
            root.right = new Node(5);
            root.left.left = new Node(1);
            root.left.right = new Node(4);
            System.out.println("Height is " + solve(root));
        }


    private static int solve(Node root) {
        if (root == null) return 0;
        int lHeight = solve(root.left);
        int rHeight = solve(root.right);
        int height = Math.max(lHeight, rHeight) + 1;
        return height;
    }
}
