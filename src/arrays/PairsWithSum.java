package arrays;

import java.util.HashMap;

public class PairsWithSum {
    public static void main(String[] args) {
        int sum = 6;
        int n = 4;
        int[] arr = {1, 5, 7, 1};
        System.out.println(getPairsCount(arr, n, sum));

    }

    public static int getPairsCount(int arr[], int n, int sum) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sum - arr[i])) {
                count += map.get(sum - arr[i]);
            }
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(map.get(arr[i]) + 1));
        }
        return count;

    }


}
