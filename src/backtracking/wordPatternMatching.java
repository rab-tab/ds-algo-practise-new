package backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class wordPatternMatching {
    public static void main(String[] args) {
        String str = "graphtreesgraph";
        String pattern = "pep";
        HashMap<Character, String> map = new HashMap<>();
        patternMatching(str, pattern, map, pattern);
    }

    private static void patternMatching(String str, String pattern, HashMap<Character, String> map, String op) {
        if (pattern.length() == 0) {
            if (str.length() == 0) {
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if (alreadyPrinted.contains(ch) == false) {
                        System.out.println(ch + "->" + map.get(ch) +", ");
                        alreadyPrinted.add(ch);
                    }
                }
            }
            return;
        }
        char ch = pattern.charAt(0);
        String temp = pattern.substring(1);
        if (map.containsKey(ch)) {
            String previousMapping = map.get(ch);
            if (str.length() >= previousMapping.length()) {
                String left = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());
                if (previousMapping.equals(left)) {
                    patternMatching(right, temp, map, op);
                }
            }

        } else {
            for (int i = 0; i < str.length(); i++) {
                String leftpart = str.substring(0, i + 1);
                map.put(ch, leftpart);
                String rightPart = str.substring(i + 1);
                patternMatching(rightPart, temp, map, op);
                map.remove(ch);
            }
        }


    }

}
