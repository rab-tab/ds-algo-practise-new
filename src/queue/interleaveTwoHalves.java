package queue;

import java.util.LinkedList;
import java.util.Queue;

public class interleaveTwoHalves {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        solve(q);
    }

    private static void solve(Queue<Integer> q1) {
        int n = q1.size();
        if (n == 0) return;
        int idx = n / 2;
        int count = 0;
        Queue<Integer> q2 = new LinkedList<>();

        //step 1
        while (!q1.isEmpty()) {
            int temp = q1.peek();
            q1.remove();
            q2.add(temp);
            count++;
            if (count == idx) break;
        }

        //step 2 : interleaving
        while (!q2.isEmpty() && !q1.isEmpty()) {
            int temp1 = q2.peek();
            q2.remove();
            q1.add(temp1);
            int temp2 = q1.peek();
            q1.remove();
            q1.add(temp2);

        }
        while (!q1.isEmpty()) {
            int temp = q1.peek();
            q1.remove();
            q1.add(temp);
        }
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
