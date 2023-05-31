package trees;

public class printTreePaths {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(2);
        solve(root, "");
    }

    private static void solve(Node root, String ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans = ans + " " + root.data;
            System.out.println(ans);
            return;
        }
        solve(root.left, ans + " " + root.data);
        solve(root.right, ans + " " + root.data);
    }
}
