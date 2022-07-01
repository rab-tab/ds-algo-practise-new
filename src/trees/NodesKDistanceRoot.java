package trees;

public class NodesKDistanceRoot {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        solve(root,1);
    }

    public static void solve(Node root,int k)
    {

        if(root==null) return;
        if(k==0) {
            System.out.println(root.data);
            return;
        }
        solve(root.left,k-1);
        solve(root.right,k-1);

    }
}
