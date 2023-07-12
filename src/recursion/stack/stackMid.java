package recursion.stack;

import java.util.Stack;

public class stackMid {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        midElem(s, s.size());


    }

    public static void midElem(Stack<Integer> s, int size) {
        if (s.size() == 0) {
            System.out.println("No elems in stack");
            return;
        }

        if (s.size() == size / 2 + 1) {
            System.out.println("mid elem is " + s.peek());
            return;
        }
        int temp = s.peek();
        s.pop();
        midElem(s, size);
        s.push(temp);

    }
}
