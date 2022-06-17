package arrays;

public class maxSumSubArray {

    public static void main(String[] args) {
        int arr[] = {4, 3, -6, -14};
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        System.out.println(maxSum(arr, currSum, maxSum));


    }

    public static int maxSum(int[] arr, int currSum, int maxSum) {
        for (int i = 0; i < arr.length; i++) {
            if (currSum >= 0) {
                currSum = currSum + arr[i];
            } else
                currSum = arr[i];
            if(currSum>maxSum)
                maxSum=currSum;
        }
        return maxSum;

    }

}
