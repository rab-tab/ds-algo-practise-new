package dp;

public class perfectSquares {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 25;
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(solve(n, dp));
    }

    private static int solve(int n, int[] dp) {

     /*   for (int i = 1; i <= Math.sqrt(n); i++) {
            System.out.println("including .. " + i + "square");
            sum = sum + i * i;
            if (sum == n) break;
        }*/

        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        for (int i = 1; i <= Math.sqrt(n); i++) {
            ans = Math.min(ans, 1 + solve((n - i * i), dp));

        }
        return dp[n] = ans;
    }
}
