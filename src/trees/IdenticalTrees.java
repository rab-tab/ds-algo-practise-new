package trees;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTrees {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        identicalTrees(root1,root2);
    }

    public static boolean identicalTrees(Node root1,Node root2){
        Queue<Node> q1=new LinkedList<>();
        Queue<Node> q2=new LinkedList<>();

        q1.add(root1);
        q2.add(root2);
        while(!q1.isEmpty() && !q2.isEmpty())
        {
            Node n1=q1.peek();
            Node n2=q2.peek();

            if(n1.data!=n2.data) return false;
            q1.remove();
            q2.remove();

            if(n1.left!=null && n2.left!=null)
            {
                q1.add(n1.left);
                q2.add(n2.left);

            }
            else if(n1.left!=null && n2.left==null || n1.left==null && n2.left!=null )
                return false;
            if(n1.right!=null && n2.right!=null)
            {
                q1.add(n1.right);
                q2.add(n2.right);

            }
            else if(n1.right!=null && n2.right==null || n1.right==null && n2.right!=null )
                return false;
        }
        return true;

    }

}
