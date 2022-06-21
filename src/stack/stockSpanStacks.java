package stack;

import java.util.Stack;

public class stockSpanStacks {
    public static void main(String[] args) {

        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        // 100 : 1
        // 80 :1
        //60  : 1
        //70 :2
        stockSpan(arr);
    }

    public static void stockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int ngl[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) ngl[i] = -1;
            else if (!stack.isEmpty() && stack.peek() > arr[i])
                ngl[i] = stack.peek();
            else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) ngl[i] = -1;
                if (stack.peek() > arr[i]) ngl[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for(Integer i:ngl)
        {
            System.out.println(i);
        }

    }
}
