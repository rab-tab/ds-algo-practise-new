package recursion.subsequences;

public class StringSubsequencesApproach2 {
    public static void main(String[] args) {
        String s = "abc";
        solve(s, 0, "");
    }


    public static void solve(String s, int idx, String ans) {

        if (idx == s.length()) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(idx);
        solve(s, idx + 1, ans + ch);
        solve(s, idx + 1, ans + "");

    }
}
