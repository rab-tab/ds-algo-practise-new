package stack.minStack;

import java.util.Stack;

public class MaximumStack {
    Stack<Integer> mainStack;
    Stack<Integer> helperStack;


    public MaximumStack() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int val) {

        mainStack.push(val);
        if (helperStack.isEmpty() || val >= helperStack.peek()) {
            helperStack.push(val);
        }
    }

    public void pop() {
        int temp = mainStack.pop();
        if (helperStack.peek() == temp) {
            helperStack.pop();
        }
    }

    public int getMax() {
        if (helperStack.isEmpty()) return -1;
        else return helperStack.peek();
    }

    public int top() {
        if (mainStack.isEmpty()) return -1;
        else return mainStack.peek();
    }

    public void display() {
        while (!mainStack.isEmpty()) {
            mainStack.peek();
        }
    }
}
