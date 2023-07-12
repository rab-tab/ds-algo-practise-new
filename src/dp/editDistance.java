package dp;

//imp
public class editDistance {
    public static void main(String[] args) {
        String s1 = "abcer";
        String s2 = "abcd";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(topDown(s1, s2, 0, 0, dp));

    }

    private static int topDown(String s1, String s2, int i, int j, int[][] dp) {

        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j))
            ans = topDown(s1, s2, i + 1, j + 1, dp);
        else {
            int insertAns = 1 + topDown(s1, s2, i, j + 1, dp);
            int replaceAns = 1 + topDown(s1, s2, i + 1, j + 1, dp);
            int deleteAns = 1 + topDown(s1, s2, i + 1, j, dp);
            ans = Math.min(Math.min(insertAns, replaceAns), deleteAns) + 1;
        }
        return dp[i][j] = ans;
    }
}
