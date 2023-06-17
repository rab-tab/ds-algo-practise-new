package dp.lis;

import java.util.Arrays;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int curr = 0;
        int prev = -1;
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Longest increasing subsequence length using recursion --" + solve(nums, curr, prev));

        int dp[][] = new int[nums.length][nums.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Longest increasing subsequence length using top down approach --" + topDown(nums, curr, prev, dp));

        int dp1[][] = new int[nums.length][nums.length + 1];
        for (int i = 0; i < dp1.length; i++) {
            for (int j = 0; j < dp1[i].length; j++) {
                dp1[i][j] = 0;
            }
        }
        System.out.println("Longest increasing subsequence length using tabulation --" + tabulation(nums, dp1));

    }

    private static int solve(int[] arr, int curr, int prev) {
        if (curr >= arr.length) return 0;
        int include = 0;
        //include
        if (prev == -1 || arr[curr] > arr[prev])
            include = 1 + solve(arr, curr + 1, curr);
        //exclude
        int exclude = 0 + solve(arr, curr + 1, prev);
        int ans = Math.max(include, exclude);
        return ans;

    }

    private static int topDown(int[] arr, int curr, int prev, int[][] dp) {
        if (curr >= arr.length) return 0;
        int include = 0;
        //include
        if (dp[curr][prev + 1] != -1) return dp[curr][prev + 1];
        if (prev == -1 || arr[curr] > arr[prev])
            include = 1 + topDown(arr, curr + 1, curr, dp);
        //exclude
        int exclude = 0 + topDown(arr, curr + 1, prev, dp);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }


    //fix required
    private static int tabulation(int[] arr, int[][] dp) {
        int n = arr.length;
        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                //include
                int include = 0;
                if (prev == -1 || arr[curr] > arr[prev])
                    include = 1 + dp[curr][curr];
                //exclude
                int exclude = 0 + dp[curr][prev+1];
                dp[curr][prev + 1] = Math.max(include, exclude);

            }
        }
        return dp[0][0];

    }

}
