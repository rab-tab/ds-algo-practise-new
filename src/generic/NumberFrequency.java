package generic;

import java.util.HashMap;
import java.util.Set;

public class NumberFrequency {
    public static void main(String[] args) {
        int i = 213888;

        HashMap<Integer, Integer> digitCount = new HashMap<Integer, Integer>();
        while (i != 0) {
            int lastDigit = i % 10;
            if (digitCount.containsKey(lastDigit)) {
                digitCount.put(lastDigit, digitCount.get(lastDigit) + 1);
            } else {
                digitCount.put(lastDigit, 1);
            }
            i = i / 10;
        }

        Set<Integer> keys = digitCount.keySet();
        for (Integer k : keys) {
            System.out.println("Key " + k + " Frequency " + digitCount.get(k));
        }

    }
}
