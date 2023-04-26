package recursion.stack;

import java.util.Stack;

public class stackInsertBottom {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        insertAtBottom(s, s.size());
        while(!s.empty())
        {
            System.out.println(s.peek());
            s.pop();
        }


    }

    public static void solve(Stack<Integer> s, int target) {
        if (s.empty()) {
            s.push(target);
            return;
        }
        int topElem = s.peek();
        s.pop();
        solve(s, target);
        s.push(topElem);
    }

    public static void insertAtBottom(Stack<Integer> s, int size) {
        if (s.empty()) {
            System.out.println("Stack empty..cannot insert at bottom");
            return;
        }
        int target = s.peek();
        s.pop();
        solve(s, target);

    }
}
