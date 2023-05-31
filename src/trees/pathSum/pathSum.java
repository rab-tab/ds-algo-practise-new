package trees.pathSum;

import trees.Node;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
       /* Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(1);
        int targetSum = 8;*/
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(2);
        int currSum = 0;
        int targetSum = 10;
        solve(root, targetSum, currSum);
    }

    private static void solve(Node root, int targetSum, int currSum) {

        if (root.left == null && root.right == null) {
            if (targetSum == currSum) {
                System.out.println("target sum equal to curr sum");
                for (Integer i : temp) System.out.print(i + "  ");
                System.out.println();
                //undo changes
                if (temp.size() >= 1) {
                    int elem = temp.get(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                    currSum = currSum - elem;
                }
                return;
            }
        }
        if (root == null) return;

        currSum = currSum + root.data;
        temp.add(root.data);
        solve(root.left, targetSum, currSum);
        //undo changes
        if (temp.size() >= 1) {
            int elem = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            currSum = currSum - elem;
        }

        //right subtree
        solve(root.right, targetSum, currSum);


    }
}
