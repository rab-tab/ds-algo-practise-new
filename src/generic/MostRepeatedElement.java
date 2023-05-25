package generic;

import java.util.HashMap;

public class MostRepeatedElement {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {4, 5, 8, 7, 4, 7, 6, 7};
        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (elementCountMap.containsKey(i)) {
                elementCountMap.put(i, elementCountMap.get(i) + 1);

            } else {
                elementCountMap.put(i, 1);
            }

        }

        int max = 0, maxValue = 0;
        for (Integer key : elementCountMap.keySet()) {
            System.out.println("Key is " + key);
            System.out.println("Value is " + elementCountMap.get(key));
            if (elementCountMap.get(key) > max) {

                max = elementCountMap.get(key);
                maxValue = key;
            }

        }
        System.out.println("Most frequent key is " + maxValue);

    }
}
