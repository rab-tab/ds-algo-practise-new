package recursion.subsequences;

public class MaxSumNonAdjacentSubsequence {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        maxSum(arr, "", 0, 0);
        System.out.println("Max is" + max);

    }

    private static void maxSum(int[] arr, String ans, int currSum, int level) {
        // if (idx == arr.length - 1) {
        if (level >= arr.length) {
            if (currSum > max) {
                max = currSum;
                System.out.println(ans);

            }
            return;
        }
        maxSum(arr, ans, currSum, level + 1);
        maxSum(arr, ans + "--" + arr[level], currSum + arr[level], level + 2);
    }
}
