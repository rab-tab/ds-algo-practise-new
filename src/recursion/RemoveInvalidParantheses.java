package recursion;

import java.util.Stack;

public class RemoveInvalidParantheses {
    public static void main(String[] args) {
        String str = "";
        int min=solve(str);
        System.out.println("Min brackets to be removed "+min);

    }

    public static int solve(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.size() == 0) stack.push(ch);
                else if (stack.peek() == ')') stack.push(ch);
                else if (stack.peek() == '(') stack.pop();
            }
        }
        return stack.size();

    }
}
