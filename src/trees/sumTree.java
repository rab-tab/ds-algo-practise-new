package trees;

public class sumTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
        System.out.println("total sum "+solveSumTree(root));

    }

    public static int solveSumTree(Node root){

        if(root==null) return 0;

        int leftAns=solveSumTree(root.left);
        int rightAns=solveSumTree(root.right);
        root.data=leftAns+rightAns+root.data;
        return root.data;

    }
}
