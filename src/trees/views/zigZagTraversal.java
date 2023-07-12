package trees.views;

import trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigZagTraversal {
    static Queue<Node> q = new LinkedList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> tempAns = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        tempAns.add(root.data);
        ans.add(tempAns);
        solve(root);
        printSolution();
    }

    private static void printSolution() {
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> nums = ans.get(i);
            for (Integer j : nums) {
                System.out.print(j + " ");
            }
            System.out.println("--------");

        }
    }

    private static void solve(Node root) {
        int level = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.peek();
            //System.out.println(temp.data);
            q.remove();
            tempAns = new ArrayList<>();
            if (temp == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                level = level + 1;
            } else {
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                if (level % 2 != 0) {
                    System.out.println("level is odd " + level);
                    if (temp.right != null) {
                        tempAns.add(temp.right.data);
                        System.out.println("adding right of " + temp.data + " --- " + temp.right.data);
                    }
                    if (temp.left != null) {
                        tempAns.add(temp.left.data);
                        System.out.println("adding left of " + temp.data + " --- " + temp.left.data);
                    }

                } else {
                    System.out.println("level is even " + level);
                    if (temp.left != null) {
                        tempAns.add(temp.left.data);
                        System.out.println("adding " + temp.left.data);
                    }
                    if (temp.right != null) {
                        tempAns.add(temp.right.data);
                        System.out.println("adding " + temp.right.data);
                    }
                }
            }

           /* if (temp == null) {
                level = level + 1;
            }*/
            ans.add(tempAns);
        }

    }
}
