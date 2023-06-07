package dp.coinChange;

public class coinChangeTopDown {
    //find min no of coins to create target amount
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        int amount = 11;
        int dp[] = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println("Min no of coins " + solve(arr, amount, dp));
    }

    private static int solve(int[] arr, int amount, int[] dp) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];
        for (int i = 0; i < arr.length; i++) {
            int ans = solve(arr, amount - arr[i], dp);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(1 + ans, min);
            }
        }
        dp[amount] = min;
        return min;
    }
}
