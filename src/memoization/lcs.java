package memoization;

import java.util.ArrayList;
import java.util.Arrays;

public class lcs {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for(int row=0;row<dp.length;row++)
        {
            for(int col=0;col<dp.length;col++)
            {
                System.out.println(dp[row][col]);
            }
        }
        System.out.println(lcs(s1, s2, s1.length(), s2.length(), dp));
    }

    public static int lcs(String s1, String s2, int m, int n, int[][] dp) {
       /* if (m == 0 || n == 0) {
            return 0;
        }*/
        if (dp[m][n] != -1) return dp[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, dp);

        } else return dp[m][n] = Math.max(lcs(s1, s2, m - 1, n, dp), lcs(s1, s2, m, n - 1, dp));
    }
}
