package recursion.coinChange;

public class coinChange {
    //find min no of coins to create target amount

    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        int amount = 11;
        System.out.println("Min no of coins " + solve(arr, amount));
    }

    private static int solve(int[] arr, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int ans = solve(arr, amount - arr[i]);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(ans + 1, min);
            }
        }
        return min;
    }
}
