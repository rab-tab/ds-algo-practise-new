package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSumDuplicates {
    static List<Integer> currSubset = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int target = 4;
        int sum = 0;
        combinationSum(arr, arr.length, sum, 0, target);
    }

    public static void combinationSum(int[] arr, int len, int sum, int currIndex, int target) {
        if (sum == target) {
            for (Integer i : currSubset) {
                System.out.print(i + " , ");
            }
            System.out.println("---------------------------");
            return;
        }
        if (currIndex == len || sum > target) {
            return;
        }
        //left child
        sum = sum + arr[currIndex];
        currSubset.add(arr[currIndex]);
        combinationSum(arr, len, sum, currIndex , target);
        //now undo changes done for left child
        sum = sum - arr[currIndex];
        currSubset.remove(currSubset.size() - 1);
        combinationSum(arr, len, sum, currIndex + 1, target);

    }

}
