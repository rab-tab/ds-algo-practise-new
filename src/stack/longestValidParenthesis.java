package stack;

import java.util.Stack;

public class longestValidParenthesis {
    public static void main(String[] args) {

        //  String str = "(())";
        // String str = "))";
        String str = ")()())()";
        Stack<Character> s = new Stack<>();
        solve(str, s);

    }

    private static void solve(String str, Stack<Character> s) {
        int len = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '(')
                s.push('(');
            else if (!s.isEmpty() && str.charAt(i) == ')') {
                s.pop();
                len++;
            } else if (s.isEmpty() && str.charAt(i) == ')') {
                System.out.println("Continuing");
                i++;
                continue;
            }
            i++;
        }

        System.out.println("Length is " + len * 2);
    }
}
