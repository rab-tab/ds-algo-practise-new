package dp.coinChange;

public class coinChangeRecursion {
    public static void main(String[] args) {
        int coins[] = {1, 2,5};
        int amount = 11;
        System.out.println("Min no of coins " + solve(coins, amount));
    }

    private static int solve(int[] coins, int amount) {

        System.out.println("in solve");
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solve(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans+1);
            }
        }
        return min;
    }
}
