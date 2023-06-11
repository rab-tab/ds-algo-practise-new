package recursion;

public class GuessingGame {
    public static void main(String[] args) {
        int n = 10;
        int start = 1;
        int end = n;
        System.out.println(solve(n, start, end));

    }

    private static int solve(int n, int start, int end) {
        if (start >= end) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solve(n, start, i - 1), solve(n, i + 1, end)));
        }
        return ans;
    }
}
