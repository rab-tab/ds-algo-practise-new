package backtracking;

import java.util.HashSet;

//https://www.youtube.com/watch?v=PiwttDa5FMA&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=26
public class kDistinctCharsSelection {
    public static void main(String[] args) {
        String s = "abcabc";
        String uniqueStr = "";
        int k = 2;
        HashSet<Character> set = new HashSet<>();
        System.out.println("Chars in hashset");
        for (Character c : s.toCharArray()) {
            if (set.contains(c) == false) {
                set.add(c);
                uniqueStr = uniqueStr + c;
            }
            System.out.println(c);
        }
        System.out.println("Unique str is "+uniqueStr);
        solve(uniqueStr, 0, "", k, 0);

    }

    public static void solve(String s, int level, String ans, int k, int totalChars) {
        if (level == s.length()) {
            if (k == totalChars) {
                System.out.println(ans);

            }
            return;
        }
        char ch = s.charAt(level);
        solve(s, level + 1, ans + "", k, totalChars);
        solve(s, level + 1, ans + ch, k, totalChars + 1);

    }
}
