package recursion.stairsPath;

public class stairsTotalPaths {
    public static void main(String[] args) {
        int n = 3;
        int ans = solve(3);
        System.out.println("Total no of ways to climb "+n + " stairs is " + ans);
    }


    public static int solve(int n) {
        //base case
        if (n == 0) return 1;
        if (n < 0) return 0;
        return solve(n - 1) + solve(n - 2);

    }
}
