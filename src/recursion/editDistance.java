package recursion;

public class editDistance {
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(solve(s1, s2, 0, 0));

    }

    private static int solve(String s1, String s2, int i, int j) {
        if (i == s1.length() && j != s2.length()) return s2.length() - j;
        if (i != s1.length() && j == s2.length()) return s1.length() - i;
        int ans = 0;
        if (i <= s1.length() - 1 && j <= s2.length()) {
            if (s1.charAt(i) == s2.charAt(j))
                ans = solve(s1, s2, i + 1, j + 1);
            else {
                //insert  solve(s1, s2, i, j + 1)
                //replace  solve(s1, s2, i + 1, j + 1)
                //delete   solve(s1, s2, i + 1, j)
                int insertAns = solve(s1, s2, i, j + 1);
                int replaceAns = solve(s1, s2, i + 1, j + 1);
                int deleteAns = solve(s1, s2, i + 1, j);
                ans = Math.min(Math.min(insertAns, replaceAns), deleteAns) + 1;
            }
        }
        return ans;
    }
}
