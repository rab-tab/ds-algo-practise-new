package stack;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr = {};
        findCeleb(arr);
    }

    public static void findCeleb(int[][] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.add(i);
        }

        while (stack.size() >= 2) {
            int fist = stack.pop();
            int second = stack.pop();
            if (arr[fist][second] == 1) {
                //if first knows second then first is not celeb
                stack.push(second);

            } else {
                //if first doesnt know second, the  second isnt celeb
                stack.push(fist);
            }

        }

        int potentialCeleb = stack.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != potentialCeleb) {
                if ((arr[i][potentialCeleb] == 0) || arr[potentialCeleb][i] == 1)
                    System.out.println("None");
                return;
            }
        }
        System.out.println(potentialCeleb);
    }
}
