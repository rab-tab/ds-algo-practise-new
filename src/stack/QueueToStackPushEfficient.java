package stack;

import java.util.Queue;

public class QueueToStackPushEfficient {
    Queue<Integer> mainQueue;
    Queue<Integer> helperQueue;

    public static void main(String[] args) {

    }

    int size() {
        return mainQueue.size();
    }


    int top() {
        int val;
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            while (mainQueue.size() > 1) {
                helperQueue.add(mainQueue.remove());

            }
            val = mainQueue.remove();
            helperQueue.add(val);
            while (mainQueue.size() > 0) {
                mainQueue.add(helperQueue.remove());
            }
        }
        return val;

    }
    

    void push(int val) {

        mainQueue.add(val);

    }

    int pop() {
        int val;
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            while (mainQueue.size() > 1) {
                helperQueue.add(mainQueue.remove());

            }
            val = mainQueue.remove();
            while (mainQueue.size() > 0) {
                mainQueue.add(helperQueue.remove());
            }
        }
        return val;

    }
}
