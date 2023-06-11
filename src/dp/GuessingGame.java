package dp;

public class GuessingGame {
    public static void main(String[] args) {
        int n = 10;
        int start = 1;
        int end = n;
        System.out.println("Using recursion " + solve(n, start, end));
        int[][] dp = new int[start + 1][end + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using top down " + topDown(n, start, end, dp));
    }

        private static int solve(int n, int start, int end) {
        if (start >= end) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solve(n, start, i - 1), solve(n, i + 1, end)));
        }
        return ans;
    }

    private static int topDown(int n, int start, int end, int[][] dp) {
        if (start >= end) return 0;
        if (dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solve(n, start, i - 1), solve(n, i + 1, end)));
        }
        return dp[start][end] = ans;
    }
}

