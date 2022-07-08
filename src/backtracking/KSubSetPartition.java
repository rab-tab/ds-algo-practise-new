package backtracking;

import java.util.ArrayList;

public class KSubSetPartition {
    static int counter=0;
    public static void main(String[] args) {
        int k = 2;
        int arr[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        subsetPartitions(1, arr, k, 0, ans);
    }

    private static void subsetPartitions(int i, int[] arr, int k, int nos, ArrayList<ArrayList<Integer>> ans) {

        if (i > arr.length) {
            if (nos == k) {
                counter++;
                System.out.println(counter+".");
                for(ArrayList<Integer> set:ans)
                {
                    System.out.print(set + " ");
                }
                System.out.println();

            }
            return;
        }
        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(i);
                subsetPartitions(i+1, arr, k, nos, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(i);
                subsetPartitions(i+1, arr, k, nos + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }
}
