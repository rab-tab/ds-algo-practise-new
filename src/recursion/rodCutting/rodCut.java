package recursion.rodCutting;

public class rodCut {
    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 2;
        int z = 2;
        int ans = solve(n, x, y, z);
        if(ans<0) ans=0;
        System.out.println(ans);

    }

    private static int solve(int n, int x, int y, int z) {
        if (n == 0)
            return 0;
        if(n<0) return Integer.MIN_VALUE;
            int a = solve(n - x, x, y, z) + 1;
            int b = solve(n - y, x, y, z) + 1;
            int c = solve(n - z, x, y, z) + 1;

        int ans = Math.max(a, Math.max(b, c));
        return ans;

    }
}
