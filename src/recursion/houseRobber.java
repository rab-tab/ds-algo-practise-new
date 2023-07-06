package recursion;

public class houseRobber {
    //maximum amount of money that can be stolen
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println("Recursion -maximum amount of money that can be stolen--" + solve(arr, arr.length - 1));
        int dp[] = new int[arr.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println("DP( top down) - maximum amount of money that can be stolen--" + dpSolve(arr, arr.length - 1, dp));

        int dp1[] = new int[arr.length + 1];
        tabulation(arr, arr.length - 1, dp1);
        System.out.println("Tabulation - maximum amount of money that can be stolen--" + tabulation(arr, arr.length - 1, dp1));

    }

    private static int solve(int[] arr, int n) {

        if (n < 0) return 0;
        if (n == 0) return arr[0];
        int incl = solve(arr, n - 2) + arr[n];
        int excl = solve(arr, n - 1) + 0;
        int ans = Math.max(incl, excl);
        return ans;

    }

    private static int dpSolve(int arr[], int n, int[] dp) {

        if (n < 0) return 0;
        if (n == 0) return arr[0];
        if (dp[n] != -1) return dp[n];
        int incl = dpSolve(arr, n - 2, dp) + arr[n];
        int excl = dpSolve(arr, n - 1, dp) + 0;
        int ans = Math.max(incl, excl);
        return dp[n] = ans;
    }

    private static int tabulation(int arr[], int n, int[] dp1) {
        dp1[0] = arr[0];
        for (int i = 1; i <= n; i++) {
            int incl = 0;
            if (i - 2 >= 0) {
                incl = dp1[i - 2] + arr[i];
                int excl = dp1[i - 1] + 0;
                dp1[i] = Math.max(incl, excl);
            }

        }
        return dp1[n];
    }
}
