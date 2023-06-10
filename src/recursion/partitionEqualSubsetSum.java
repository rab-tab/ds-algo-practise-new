package recursion;

public class partitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
        } else {
            int target = sum / 2;
            boolean ans = solve(0, arr, target);
            System.out.println("Can arr be divied into two equal partitions--- "+ans);
        }

    }

    private static boolean solve(int index, int[] nums, int target) {
        if (index >= nums.length) return false;
        if (target < 0) return false;
        if (target == 0) return true;

        boolean include = solve(index + 1, nums, target - nums[index]);
        boolean exclude = solve(index + 1, nums, target);
        return include || exclude;

    }
}
