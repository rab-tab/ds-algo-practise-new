package recursion.stack;

import java.util.Stack;

public class validParenthesis {
    public static void main(String[] args) {
        String str = "{}[]()";
        Stack<Character> s = new Stack<>();
        System.out.println(solve(str, s));
    }

    private static boolean solve(String str, Stack<Character> s) {
        if (str == "") return false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[')
                s.push(ch);
            else {
                if (!s.isEmpty()) {
                    if (s.peek() == '{' && ch == '}')
                        s.pop();
                    else if (s.peek() == '(' && ch == ')')
                        s.pop();
                    else if (s.peek() == '[' && ch == ']')
                        s.pop();
                }
            }
        }
        if (s.isEmpty()) return true;
        return false;
    }
}
