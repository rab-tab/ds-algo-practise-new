package backtracking;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {
        List<StringBuffer> ans = new ArrayList<>();
        int n = 3;
        int open = n;
        int close = n;
        StringBuffer sb = new StringBuffer("");
        solve(ans, open, close, n, sb);


    }

    private static void solve(List<StringBuffer> ans, int open, int close, int n, StringBuffer sb) {
        if (open == 0 && close == 0) {
            ans.add(sb);
            for (StringBuffer s : ans) {
                System.out.println(s);
            }
            ans.clear();
            return;
        }
        //include open bracket
        if (open > 0) {
            sb = sb.append("(");
            solve(ans, open - 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);

        }

        //include close bracket
        if (close > open) {
            sb = sb.append(")");
            solve(ans, open, close - 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
