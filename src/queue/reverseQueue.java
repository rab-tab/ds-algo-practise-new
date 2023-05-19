package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(6);
        q.add(9);
        q.add(2);
        q.add(8);
        solve(q);
    }

    private static void solve(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        //step 1 : put all elems of queue in stack
        while (!q.isEmpty()) {
            int elem = q.peek();
            q.remove();
            s.push(elem);

        }
        //step 2 : put all elems from stack to queue
        while (!s.isEmpty()) {
            int elem = s.peek();
            s.pop();
            q.add(elem);
        }

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
