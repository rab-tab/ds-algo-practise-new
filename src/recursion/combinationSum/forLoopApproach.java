package recursion.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class forLoopApproach {
    static List<Integer> tempAns = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {2, 3, 6, 7};
        //{2,2,3} ,{7};
        int targetSum = 7;
        solve(arr, targetSum, 0, 0);
    }


    public static void solve(int arr[], int targetSum, int currSum, int idx) {
        if (targetSum == currSum) {
            for (Integer i : tempAns) {
                System.out.println(i);
            }
            ans.add(tempAns);
            System.out.println();
            return;
        }

        if (idx == arr.length || currSum > targetSum) return;
        for (int i = idx; i < arr.length; i++) {
            tempAns.add(arr[i]);
            solve(arr, targetSum, currSum + arr[i], i);
            tempAns.remove(tempAns.size() - 1);

        }
    }

}
