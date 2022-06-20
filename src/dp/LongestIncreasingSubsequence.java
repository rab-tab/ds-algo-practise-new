package dp;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int dp[] = new int[arr.length];
        dp[0] = 1;

        lis(arr, dp);
    }


    public static void lis(int arr[], int dp[]) {
        int omax = 0;
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] > max)
                        max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        System.out.println("LIS is " + omax);
    }
}
