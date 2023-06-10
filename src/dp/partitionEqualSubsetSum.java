package dp;

public class partitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5,1};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        if (sum % 2 != 0) {
            System.out.println("Can arr be divided into two equal partitions - top down approach --- false" );
        } else {
            int target = sum / 2;
            boolean dp[][] = new boolean[arr.length + 1][target + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = false;
                }
            }
            boolean ans = topDownApproach(0, arr, target, dp);
            System.out.println("Can arr be divided into two equal partitions - top down approach --- " + ans);
        }

    }

    //recursion
    private static boolean solve(int index, int[] nums, int target) {
        if (index >= nums.length) return false;
        if (target < 0) return false;
        if (target == 0) return true;

        boolean include = solve(index + 1, nums, target - nums[index]);
        boolean exclude = solve(index + 1, nums, target);
        return include || exclude;

    }

    //top down approach
    private static boolean topDownApproach(int index, int[] nums, int target, boolean[][] dp) {
        if (index >= nums.length) return false;
        if (target < 0) return false;
        if (target == 0) return true;

        if (!dp[index][target] == false) return true;

        boolean include = solve(index + 1, nums, target - nums[index]);
        boolean exclude = solve(index + 1, nums, target);
        return dp[index][target] = include || exclude;

    }
}

