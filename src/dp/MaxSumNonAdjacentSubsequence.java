package dp;

public class MaxSumNonAdjacentSubsequence {

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int dp[] = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println("Max is " + maxSum(arr, 0, dp));
    }

    private static int maxSum(int[] arr, int level, int[] dp) {
        // if (idx == arr.length - 1) {
        if (level >= arr.length) {
            return 0;

        }
        if (dp[level] != -1) return dp[level];
        //exclude curr elem
        int include = arr[level] + maxSum(arr, level + 2, dp);
        //include curr elem - level becomes level+2 since adjacent elem cannot be considered
        int exclude = maxSum(arr, level + 1, dp);
        return dp[level] = Math.max(include, exclude);
    }
}
