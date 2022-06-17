package recursion;

public class maxSumSubArray {
    public static void main(String[] args) {
        int arr[] = {4, 3, -6, -14};
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        System.out.println(maxSumSubArray(arr, currSum, maxSum, 0));


    }

    public static int maxSumSubArray(int[] arr, int currSum, int maxSum, int currIndex) {
        if (currIndex > arr.length) return 0;
        currSum = currSum + arr[currIndex];
        return Math.max(maxSumSubArray(arr, currSum, maxSum, currIndex++), maxSumSubArray(arr, currSum, maxSum, currIndex));

    }
}
