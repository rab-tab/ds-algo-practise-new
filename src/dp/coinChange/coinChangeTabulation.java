package dp.coinChange;

public class coinChangeTabulation {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        int amount = 11;
        int dp[] = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        System.out.println("Min no of coins " + solve(arr, amount, dp));
    }

    private static int solve(int[] arr, int amount, int[] dp) {
        //base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0 && dp[i - arr[j]] != Integer.MAX_VALUE) {
                    int ans = dp[i - arr[j]];
                    dp[i] = Math.min(dp[i], 1 + ans);
                }
            }
        }
        return dp[amount];
    }
}
