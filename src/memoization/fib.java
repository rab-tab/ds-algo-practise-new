package memoization;

import java.util.Arrays;

public class fib {
    public static void main(String[] args) {
        int n = 12;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        System.out.println("fib of " + n + "is" + fib(n, ans));

    }

    public static int fib(int n, int[] ans) {
        if (n == 0 || n == 1) return n;
        if (ans[n] != 0) return ans[n];

        int fibn = fib(n - 1, ans) + fib(n - 2, ans);
        ans[n] = fibn;
        return fibn;
    }
}
