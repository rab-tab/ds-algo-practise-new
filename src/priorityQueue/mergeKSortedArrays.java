package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = {{2, 4, 6, 8},
                {1, 3, 5, 7},
                {0, 9, 10, 11}};
        int k = 3;
        int n = 4;
        int[] ans = mergeKSortedArrays(k, n, arr);
        System.out.println("Merged array--- ");
        for (int i : ans) {
            System.out.println(i);
        }

    }

    public static int[] mergeKSortedArrays(int k, int n, int[][] arr) {
        int[] ans = new int[n];
        PriorityQueue<List<Data>> minHeap = new PriorityQueue<List<Data>>(k, new Compare());
        List<Data> tempList;
        for (int i = 0; i < k; i++) {
            tempList = new ArrayList<>();
            Data temp = new Data(arr[i][0], i, 0);
            tempList.add(temp);
            minHeap.add(tempList);
        }
        int currIdx = 0;
        while (!minHeap.isEmpty()) {
            Data temp = minHeap.peek().get(currIdx);
            int topElem = temp.value;
            int topRow = temp.row;
            int topCol = temp.col;
            ans[currIdx] = topElem;
            currIdx++;
            minHeap.peek();
            if (topCol + 1 < n) {
                List<Data> tempAns = new ArrayList<>();
                Data data = new Data(arr[topRow][topCol + 1], topRow, topCol + 1);
                tempAns.add(data);
                minHeap.add(tempAns);
            }
        }
        return ans;

    }
}
