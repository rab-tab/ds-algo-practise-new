package recursion.combinationSum;

public class combinationSumWithRepitition {
    public static void main(String[] args) {
        int[] coins = {2, 3, 6, 7};
        int totalSum = 7;
        int currSum = 0;
        combinationSum(coins, totalSum, currSum, "", 0);
    }

    private static void combinationSum(int[] coins, int totalSum, int currSum, String currCombination, int currIndex) {
        // if (currIndex >= coins.length) return;
        if (totalSum == currSum) {
            System.out.println(currCombination);
            return;
        }
        if(currIndex==coins.length || currSum>totalSum) return;
        //include same index
        combinationSum(coins, totalSum, currSum + coins[currIndex], currCombination+coins[currIndex],
                currIndex);
        //include current level coin
        combinationSum(coins, totalSum, currSum, currCombination,
                currIndex + 1);


    }
}
