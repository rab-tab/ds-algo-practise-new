package dp;

public class knapsack {
    public static void main(String[] args) {
        int n = 3;
        int capacity = 50;
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        System.out.println(solve(val, wt, capacity, 0));
    }

    private static int solve(int[] val, int[] wt, int capacity, int idx) {

        if (idx == val.length || capacity == 0) return 0;
        int include = 0;
        if (capacity >= wt[idx]) {
            include = val[idx] + solve(val, wt, capacity - wt[idx], idx + 1);

        }
        int exclude = 0 + solve(val, wt, capacity - wt[idx], idx + 1);
        return Math.max(include, exclude);

    }

}
