package backtracking;

import java.util.HashSet;

public class KLengthWordsDistinctChars {
    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        solve(s, k, "", new HashSet<Character>());

    }

    public static void solve(String s, int k, String ans, HashSet<Character> set) {
        if (ans.length() == k) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch) == false) {
                set.add(ch);
                solve(s, k, ans + ch, set);
                set.remove(ch);
            }

        }
    }
}
