package dp.houseRobber;

public class houseRobberTopDownApproach {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        int dp[] = new int[arr.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println("DP( top down) - maximum amount of money that can be stolen--" + dpSolve(arr, arr.length - 1, dp));

    }

    private static int dpSolve(int arr[], int n, int[] dp) {

        if (n < 0) return 0;
        if (n == 0) return arr[0];
        if (dp[n] != -1) return dp[n];
        int incl = dpSolve(arr, n - 2,dp) + arr[n];
        int excl = dpSolve(arr, n - 1,dp) + 0;
        int ans = Math.max(incl, excl);
        return dp[n] = ans;
    }
}
