package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min;
    int prevMin;


    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
        }
        if (val < min) {
            prevMin = min;
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek() == min) {
            System.out.println("Previous min value is "+prevMin);
            min = prevMin;
            stack.pop();

        }
        else stack.pop();
    }

    public int getMin() {
        if(stack.isEmpty()) return -1;
        return min;
    }
}
