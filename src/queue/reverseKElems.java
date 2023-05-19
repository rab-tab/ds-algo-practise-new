package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseKElems {
    public static void main(String[] args) {
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(6);
        q.add(9);
        q.add(2);
        q.add(8);
        solve(q, k);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }

    private static void solve(Queue<Integer> q, int k) {
        if (k == 0 || k > q.size()) return;
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        //step 1 : put k elems of queue in stack
        while (idx < k) {
            int temp = q.peek();
            q.remove();
            s.push(temp);
            idx++;
        }

        //step 2 : put elems from stack to queue
        while (!s.isEmpty()) {
            int elem = s.peek();
            s.pop();
            q.add(elem);
        }

        //step 3 - push n-k elems from q fron to back
        idx = 0;
        if(q.size()-k ==0 ) return;
        while (!q.isEmpty()) {
            int temp = q.peek();
            q.remove();
            q.add(temp);
            idx++;
            if (idx == q.size() - k) return;
        }

    }
}
