package dp;

public class knapsack {
    public static void main(String[] args) {
        int n = 3;
        int capacity = 50;
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int dp[][] = new int[capacity + 1][n];
        System.out.println(dp.length);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using recursion " + solve(val, wt, capacity, 0));
        System.out.println("Using top down approach  " + topDown(val, wt, capacity, 0, dp));
    }

    private static int solve(int[] val, int[] wt, int capacity, int idx) {

        if (idx == val.length || capacity == 0) return 0;
        int include = 0;
        if (capacity >= wt[idx]) {
            include = val[idx] + solve(val, wt, capacity - wt[idx], idx + 1);

        }
        int exclude = 0 + solve(val, wt, capacity - wt[idx], idx + 1);
        return Math.max(include, exclude);

    }

    private static int topDown(int[] val, int[] wt, int capacity, int idx, int[][] dp) {

        if (idx == val.length || capacity == 0) return 0;
        if (dp[capacity][idx] != -1) return dp[capacity][idx];
        int include = 0;
        if (capacity >= wt[idx]) {
            include = val[idx] + solve(val, wt, capacity - wt[idx], idx + 1);

        }
        int exclude = 0 + solve(val, wt, capacity - wt[idx], idx + 1);
        return dp[capacity][idx] = Math.max(include, exclude);

    }
}
