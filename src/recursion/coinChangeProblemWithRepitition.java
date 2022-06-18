package recursion;

public class coinChangeProblemWithRepitition {
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int totalSum = 10;
        int currSum = 0;
        coinChange(coins, totalSum, currSum, "", 0);

    }

    public static void coinChange(int[] coins, int totalSum, int currSum, String currCombination, int currIndex) {
        System.out.println("In coin change");
        if(currIndex==coins.length){
            if(totalSum==currSum){
                System.out.println(currCombination + " . ");
            }
            return;

        }

        //include current level coin
        coinChange(coins, totalSum, currSum + coins[currIndex], currCombination + coins[currIndex] + "-",
                currIndex++);

        //dont include current level coin
        coinChange(coins, totalSum, currSum, currCombination ,
                currIndex++);
    }
}
