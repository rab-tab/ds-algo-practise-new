package stack;

import java.util.Stack;

public class ngr {
    public static void main(String[] args) {
        int arr[] = {1,2,9,1};
        solve(arr, arr.length);

    }

    public static void solve(int[] arr, int n) {
        int ngr[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ngr[i] = -1;
            } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                ngr[i] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) ngr[i] = -1;
                else ngr[i] = stack.peek();
            }
            stack.push(arr[i]);

        }
        for(Integer i:ngr){
            System.out.println(i);
        }


    }
}
