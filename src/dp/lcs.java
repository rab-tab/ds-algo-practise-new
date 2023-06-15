package dp;

public class lcs {
    public static void main(String[] args) {
        String s1 = "abcdabc";
        String s2 = "bcbcda";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(topDownApproach(s1, s2, s1.length() - 1, s2.length() - 1, dp));
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
}
