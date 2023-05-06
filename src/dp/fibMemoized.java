package dp;

public class fibMemoized {
    static int n = 6;
    static int memo[] = new int[n + 1];

    public static void main(String[] args) {
        System.out.println(fib(n, memo));
        for (int i = 0; i <= n; i++) {
            memo[i] = 0;
        }
    }

    static int fib(int n, int memo[]) {
        if (n <= 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
}
