package recursion.stack;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        // 50 40 30 20 10
        reverse(s);
        System.out.println("Reversed stack..");
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    private static void reverse(Stack<Integer> s) {
        //base case
        if (s.empty()) {
            return;
        }
        int target = s.peek();
        s.pop();
        reverse(s);
        //insert at bottom
        insertAtBottom(s, target);
    }

    public static void insertAtBottom(Stack<Integer> s, int target) {
        if (s.empty()) {
            s.push(target);
            return;
        }
        int topElem = s.peek();
        s.pop();
        insertAtBottom(s, target);
        s.push(topElem);
    }
}
