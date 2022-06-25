package recursion;

import java.util.ArrayList;

public class subsequences {
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> result = generateSubsequence(s);
        System.out.println("Subsequences are ---- ");
        for (String str : result) {
            System.out.println(str);
        }
        // bc b- -c --

    }

    public static ArrayList<String> generateSubsequence(String s) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> tempRes = generateSubsequence(ros);
        ArrayList<String> mainRes = new ArrayList<>();
        for (String res : tempRes) {
            mainRes.add("" + res);
            mainRes.add(ch + res);

        }
        return mainRes;

    }
}
