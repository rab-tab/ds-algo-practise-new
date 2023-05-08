package recursion;

public class knapsack {
    public static void main(String[] args) {
        int n = 3;
        int capacity = 50;
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int[][] dp = new int[n][capacity];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(val, wt, capacity, 0, dp));
    }

    private static int solve(int[] val, int[] wt, int capacity, int idx, int[][] dp) {

        if (idx == val.length || capacity == 0) return 0;
        if (dp[idx][capacity] != -1) return dp[idx][capacity];
        int include = 0;
        if (capacity >= wt[idx]) {
            include = val[idx] + solve(val, wt, capacity - wt[idx], idx + 1, dp);

        }
        int exclude = 0 + solve(val, wt, capacity - wt[idx], idx + 1, dp);
        return dp[idx][capacity] = Math.max(include, exclude);

    }

}
