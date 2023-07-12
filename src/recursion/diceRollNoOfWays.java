package recursion;

import java.math.BigInteger;

public class diceRollNoOfWays {
    public static void main(String[] args) {

        int n = 2;
        int k = 6;
        int target = 7;
        System.out.println("Total no of ways using recursion " + solve(n, k, target));
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        topDown(n, k, target, dp);
        System.out.println("Total no of ways using top down " + topDown(n, k, target, dp));

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = 0;
            }
        }
        System.out.println("Total no of ways using tabulation " + tabulation(n, k, target, dp));

    }


    private static int solve(int n, int k, int target) {
        if (n < 0) return 0;
        if (n == 0 && target == 0) return 1;
        if (n == 0 && target != 0) return 0;
        if (n != 0 && target == 0) return 0;
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += solve(n - 1, k, target - i);
        }BigInteger a=BigInteger.valueOf(10);
        return ans;

    }

    private static int topDown(int n, int k, int target, int[][] dp) {
        if (n < 0) return 0;
        if (n == 0 && target == 0) return 1;
        if (n == 0 && target != 0) return 0;
        if (n != 0 && target == 0) return 0;
        if (dp[n][target] != -1) return dp[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += topDown(n - 1, k, target - i,dp);
        }
        return dp[n][target] = ans;

    }

    private static int tabulation(int n, int k, int target, int[][] dp) {
        dp[0][0] = 1;

        for (int index = 1; index <= n; index++) {
            for (int t = 1; t <= target; t++) {
                int ans = 0;
                for (int i = 1; i <= k; i++) {
                    if (t - i >= 0) {
                        ans += dp[index - 1][t - i];
                    }
                }
                dp[index][t] = ans;
            }
        }
        return dp[n][target];
    }


}
