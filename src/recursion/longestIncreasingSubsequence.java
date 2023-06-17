package recursion;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int curr = 0;
        int prev = -1;
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println("Longest increasing subsequence length --" +solve(nums, curr, prev));

    }

    private static int solve(int[] arr, int curr, int prev) {
        if (curr >= arr.length) return 0;
        int include = 0;
        //include
        if (prev == -1 || arr[curr] > arr[prev])
            include = 1 + solve(arr, curr + 1, curr);
        //exclude
        int exclude = 0 + solve(arr, curr + 1, prev);
        int ans = Math.max(include, exclude);
        return ans;

    }
}
