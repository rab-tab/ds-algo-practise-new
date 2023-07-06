package dp.paintingFence;

public class paintFenceRecursion {
    public static void main(String[] args) {
        int n = 4; // fences
        int k = 3; //colors
        System.out.println("Total ways " +solveUsingRecursion(n, k));
    }

    private static int solveUsingRecursion(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return (k + k * (k - 1));
        int ans = (k - 1) *( solveUsingRecursion(n - 2, k) + solveUsingRecursion(n - 1, k));
        return ans;
    }
}
