package recursion.Strings.subsequences;

import java.util.ArrayList;
import java.util.List;

public class subsetsSetInteger {

    public static List<Integer> currSubset = new ArrayList<>();
    public static List<List<Integer>> subsets = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        getSubsets(arr, 0, arr.length);
      /*  List<List<Integer>> ans = getSubsets(arr, 0, arr.length);
        System.out.println("subsets size "+ans.size());
        for (List<Integer> list : ans) {
            System.out.println("outer loop, list size is "+list.size());
            for (Integer i : list) {
                System.out.println("Innner loop");
                System.out.println(i);
            }
        }*/
    }

    public static void getSubsets(int[] arr, int currIndex, int len) {

        //base case
        if (currIndex == len) {
            if (currSubset.size() == 0) {
                System.out.println("{}");
            } else {
                for (Integer k : currSubset) {
                    System.out.print(k + " , ");

                }
                System.out.println("------------------");
            }
            subsets.add(currSubset);
            return;
        }
        //left part of the recursive tree
        getSubsets(arr, currIndex + 1, len);
        //right part of the recursive tree
        currSubset.add(arr[currIndex]);
        getSubsets(arr, currIndex + 1, len);
        //backtrack
        currSubset.remove(currSubset.size() - 1);
    }
}
