package stack;

import java.util.Stack;

public class ngl {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        int arr[] = {100, 80, 101, 50};
        int nsl[] = new int[arr.length];
        int temp[] = nearestSmallElem(arr, nsl);
        for (Integer i : temp) {
            System.out.println(i);
        }

    }

    public static int[] nearestSmallElem(int arr[], int[] nsl) {
        for (int i = 0; i <= arr.length - 1; i++) {
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                nsl[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                while (stack.size() > 0 && stack.peek() > arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    nsl[i] = -1;
                } else {
                    nsl[i] = stack.peek();
                }

            }
            stack.push(arr[i]);


        }
        return nsl;
    }
}
