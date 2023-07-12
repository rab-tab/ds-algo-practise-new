package recursion.stack;

import java.util.Stack;

public class sortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(11);
        s.push(3);
        s.push(5);
        s.push(9);
        //3 5 7 9 11
        //find out max and insert at bottom
        solve(s,s.size());

    }

    private static void solve(Stack<Integer> s, int target) {

        if(s.empty()){
            s.push(target);
            return;
        }

        if(s.peek()>=target){

        }
    }


}
