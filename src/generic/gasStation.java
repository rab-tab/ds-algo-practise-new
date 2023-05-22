package generic;

public class gasStation {
    public static void main(String[] args) {
        int gas[] = {2,3,4};
        int cost[] = {3,4,3};
        System.out.println("Starting at index " + solve(gas, cost));
    }

    private static int solve(int[] gas, int[] cost) {
        int deficit = 0;
        int balance = 0;
        int startIdx = 0;

        for (int i = 0; i < gas.length; i++) {
            balance += gas[i] - cost[i];
            if (balance < 0) {
                deficit += balance;
                startIdx = i + 1;
                balance = 0;
            }
        }
        if (balance >= deficit) return startIdx;
        else return -1;
    }

}
