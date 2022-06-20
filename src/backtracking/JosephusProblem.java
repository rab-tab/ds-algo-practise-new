package backtracking;

//https://www.youtube.com/watch?v=dzYq5VEMZIg&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=5
public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        System.out.println("Last person is "+solve(n, k));

    }


    public static int solve(int n, int k) {
        if (n == 1) return 0;
        int x = solve(n - 1, k);
        int y = (x + k) % n;
        return y;


    }
}
