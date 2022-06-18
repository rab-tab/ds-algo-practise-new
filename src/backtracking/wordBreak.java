package backtracking;

import java.util.HashSet;
import java.util.Set;

public class wordBreak {
    static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        String str = "ilikesamsung";
        String temp_dictionary[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};
        for (String temp : temp_dictionary) {
            dictionary.add(temp);
        }
        wordBreak(str, "");
    }

    public static void wordBreak(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dictionary.contains(left)) {
                String right = str.substring(i + 1);
                wordBreak(right, ans + left + " ");

            }
        }
    }
}
