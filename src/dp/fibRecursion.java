package dp;

public class fibRecursion {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(n));
    }

    static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
