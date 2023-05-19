package queue;

import java.util.LinkedList;
import java.util.Queue;

public class recursive {
    static Queue<Integer> q;

    public static void main(String[] args) {
        q = new LinkedList<>();
        q.add(3);
        q.add(6);
        q.add(9);
        q.add(2);
        q.add(8);
        solve();
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }

    private static void solve() {
        if (q.size() == 0) {
            // System.out.println(temp);
            return;
        }
        int temp = q.peek();
        q.remove();
        solve();
        q.add(temp);
    }
}
