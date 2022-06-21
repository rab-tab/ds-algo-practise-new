package stack;

import java.util.Queue;

public class QueueToStackPopEfficient {
    Queue<Integer> mainQueue;
    Queue<Integer> helperQueue;

    public static void main(String[] args) {


    }

    int size() {
        return mainQueue.size();
    }


    int top() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else return mainQueue.peek();
    }

    void push(int val) {

        while (mainQueue.size() > 0) {
            helperQueue.add(mainQueue.remove());
        }
        mainQueue.add(val);
        while (helperQueue.size() > 0) {
            mainQueue.add(helperQueue.remove());
        }

    }

    int pop() {
        if (size() == 0)
        {System.out.println("Stack underflow");
            return -1;
        }
        else{
            int temp = mainQueue.peek();
            mainQueue.remove();
            return temp;
        }

    }
}
