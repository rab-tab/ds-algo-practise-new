package stack;

import java.util.Stack;

public class MyStack {
    Stack<Integer> mainStack;
    Stack<Integer> helperStack;

    public MyStack() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
        ;
    }

    void push(int val) {
        mainStack.push(val);
        if (helperStack.isEmpty()) {
            helperStack.push(val);
        }
        //helper stack will contain the min elem
        if (val <= helperStack.peek()) {
            helperStack.push(val);
        }
    }

    void pop() {
        //if elem to be popped is min elem pop from both stacks
        if (helperStack.peek() == mainStack.peek()) {
            // int temp = min();
            helperStack.pop();
            //helperStack.push(temp);
        }
        mainStack.pop();
    }

    int min() {
        if (helperStack.isEmpty()) return -1;
        else return helperStack.peek();

    }

}
