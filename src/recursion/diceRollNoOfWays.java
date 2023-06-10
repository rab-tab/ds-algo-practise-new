package recursion;

public class diceRollNoOfWays {
    public static void main(String[] args) {
        int n = 2;
        int k = 6;
        int target = 7;

        System.out.println(solve(n, k, target));
    }

    private static int solve(int n, int k, int target) {
        if (n < 0) return 0;
        if (n == 0 && target == 0) return 1;
        if (n == 0 && target != 0) return 0;
        if (n != 0 && target == 0) return 0;
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += solve(n - 1, k, target - i);
        }
        return ans;

    }
}
