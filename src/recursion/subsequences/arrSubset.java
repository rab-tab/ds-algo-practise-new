package recursion.subsequences;

public class arrSubset {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1};
        solve(arr, "", 0);
    }

    public static void solve(int[] arr, String ans, int idx) {
        //base case

        if (idx == arr.length) {
            System.out.println(ans);
            return;
        }
        solve(arr, ans + arr[idx], idx + 1);
        solve(arr, ans, idx + 1);

    }
}
