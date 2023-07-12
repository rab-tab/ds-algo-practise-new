package dp.paintingFence;

public class paintFenceRecursion {
    public static void main(String[] args) {
        int n = 4; // fences
        int k = 3; //colors
        System.out.println("Total ways using recusrion --" + solveUsingRecursion(n, k));
        int dp[] = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println("Total ways using memoisation-- " + solveUsingMemoization(n, k, dp));
        int dp1[] = new int[n + 1];
        System.out.println("Total ways using tabulation-- " + solveUsingTabulation(n, k, dp1));
    }

    private static int solveUsingRecursion(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return (k + k * (k - 1));
        int ans = (k - 1) * (solveUsingRecursion(n - 2, k) + solveUsingRecursion(n - 1, k));
        return ans;
    }

    private static int solveUsingMemoization(int n, int k, int[] dp) {
        if (n == 1) return k;
        if (n == 2) return (k + k * (k - 1));
        if (dp[n] != -1) return dp[n];
        int ans = (k - 1) * (solveUsingRecursion(n - 2, k) + solveUsingRecursion(n - 1, k));
        return dp[n] = ans;
    }

    private static int solveUsingTabulation(int n, int k, int[] dp) {
        dp[1] = k;
        dp[2] = (k + k * (k - 1));
        for (int i = 3; i <= n; i++) {
            int ans = (k - 1) * (dp[i - 2] + dp[i - 1]);
        }
        return dp[n];

    }
}
