package recursion;

import java.util.ArrayList;
import java.util.List;

public class sumOfAllSubsets {
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {2, 3};
        subSetsSum(arr, arr.length, 0);

    }

    public static void subSetsSum(int[] arr, int n, int idx) {

        if (idx == arr.length) {
            int sum = 0;
            for (Integer i : temp) {
                sum = sum + i;
                System.out.print(i + "-");
            }

            System.out.println("Sum is " + sum);
            return;
        }

        subSetsSum(arr, n, idx + 1);
        temp.add(arr[idx]);
        subSetsSum(arr, n, idx + 1);
        temp.remove(temp.size()-1);

    }

}
