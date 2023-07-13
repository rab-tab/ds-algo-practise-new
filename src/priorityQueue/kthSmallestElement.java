package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestElement {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 1;
        solve(arr, k);
    }

    private static void solve(int[] arr, int k) {
        //max heap - default ordering is ascending
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            System.out.println("adding " + arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }

        }
        System.out.println(k + " smallest elem is " + maxHeap.peek());
    }
}
