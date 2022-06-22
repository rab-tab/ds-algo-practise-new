package stack;

import java.util.*;

public class mergeOverlappingIntervals {
    public static void main(String[] args) {
        int arr[][]={{22,28},
                {1,8},
                {25,27},
                {14,19},
                {27,30},
                {5,12}};
        merge(arr);

    }

    public static void merge(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                stack.push(pairs[i]);
            } else {
                Pair top = stack.peek();
                if (pairs[i].startTime > top.endTime) {

                    stack.push(pairs[i]);
                } else {
                    top.endTime = Math.max(top.endTime, pairs[i].endTime);
                }
            }
        }
        Stack<Pair> result=new Stack<>();
        while(stack.size()>0)
        {
            result.push(stack.pop());
        }

        while(result.size()>0)
        {
            Pair p=result.pop();
            System.out.println(p.startTime + " --- "+ p.endTime);
        }

    }
}
