package trees;

public class NodesSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
        System.out.println("total sum "+solve(root));
    }

    public static int solve(Node root){
            if(root==null) return 0;
            return root.data+solve(root.left)+solve(root.right);
    }
}
