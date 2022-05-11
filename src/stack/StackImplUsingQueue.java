package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingQueue {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int elem = 6;
        //elem to be inserted -6
        q.add(elem);
        int currIndex = 1;
        // 1 2 3 4 5 6
        //6 1 2 3 4 5

        while (currIndex < q.size()) {
            //deuqe
            int temp = q.peek();
            System.out.println("Element to be removed ---"+temp);
            q.remove(temp);
            //enqueue
            q.add(temp);
            System.out.println("After deque and enqueue elems are");
            for (Integer i : q) {
                System.out.println(i);
            }
            currIndex++;
        }
        System.out.println("Queue elems ---");
        for (Integer i : q) {
            System.out.println(i);
        }

    }
}
