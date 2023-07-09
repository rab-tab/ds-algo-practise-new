package recursion;

//https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
public class guessNumberHigherOrLower {
    public static void main(String[] args) {
        int start = 1;
        int end = 5;
        System.out.println("Ans using recursion -- " + solve(start, end));
        int[][] dp = new int[end + 1][end + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Ans using memoisation -- " + memoisation(start, end,dp));
    }

    private static int solve(int start, int end) {
        if (start >= end) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solve(start, i - 1), solve(i + 1, end)));
        }
        return ans;
    }

    private static int memoisation(int start, int end, int[][] dp) {
        if (start >= end) return 0;
        if (dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, (i + Math.max(memoisation(start, i - 1,dp), memoisation(i + 1, end,dp))));
        }
        return dp[start][end] = ans;
    }

}
