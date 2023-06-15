package dp;

public class lcs {
    public static void main(String[] args) {
        String s1 = "abcdabc";
        String s2 = "bcbcda";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Top down approach --" + topDownApproach(s1, s2, s1.length() , s2.length(), dp));

        int[][] dp1 = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp1[i][j] = 0;
            }
        }

        System.out.println("Tabulation --" + tabulation(s1, s2, dp1));
    }

    public static int topDownApproach(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        int ans = 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            ans = 1 + topDownApproach(s1, s2, i - 1, j - 1, dp);
        else ans = Math.max(topDownApproach(s1, s2, i - 1, j, dp), topDownApproach(s1, s2, i, j - 1, dp));
        dp[i][j] = ans;
        return ans;
    }

    public static int tabulation(String s1, String s2, int[][] dp) {
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (s1.charAt(i) == s2.charAt(j))
                    ans = 1 + dp[i + 1][j + 1];
                else ans = Math.max(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = ans;
            }
        }
        return dp[0][0];

    }

}
