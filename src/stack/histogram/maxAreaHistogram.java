package stack.histogram;

import java.util.HashMap;
import java.util.Stack;

public class maxAreaHistogram {
    public static void main(String[] args) {
        int arr[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Max area is " + mah(arr));
    }


    public static int mah(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        int[] nsl = nslSolve(arr, hashMap);
        int[] nsr = nsrSolve(arr, hashMap);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int temp = (nsr[i] - nsl[i]) * arr[i];
            if (temp > max) max = temp;
        }
        return max;

    }


    public static int[] nslSolve(int[] arr, HashMap<Integer, Integer> map) {

        Stack<Integer> stack = new Stack<>();
        int[] nsl = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) nsl[i] = -1;
            else if (!stack.isEmpty() && stack.peek() < arr[i])
                // nsl[i]=map.get(stack.peek());
                nsl[i] = stack.peek();
            else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) nsl[i] = -1;
                if (stack.peek() < arr[i]) nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        return nsl;
    }


    public static int[] nsrSolve(int[] arr, HashMap<Integer, Integer> map) {
        Stack<Integer> stack = new Stack<>();
        int[] nsr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr[i] = arr.length;
            else if (!stack.isEmpty() && stack.peek() > arr[i])
                // nsl[i]=map.get(stack.peek());
                nsr[i] = stack.peek();
            else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) nsr[i] = arr.length;
                if (stack.peek() > arr[i]) nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        return nsr;
    }


}
