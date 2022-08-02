package generic;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

public class digitsFrequency {
    public static void main(String[] args) {
        int num = 7644;
        frequency(num);

    }

    public static void frequency(int num) {
        HashMap<Integer, Integer> occurMap = new HashMap<>();
        while (num != 0) {
            int digit = num % 10;
            System.out.println("digit is "+digit);
            if (occurMap.containsKey(digit)) {
                occurMap.put(digit, occurMap.get(digit) + 1);
            } else occurMap.put(digit, 1);
            num = num / 10;
        }

        System.out.println("Frequency is");
        for (Map.Entry<Integer, Integer> map : occurMap.entrySet()) {
            System.out.println(map.getKey() + " --- occurs " + map.getValue());
        }
    }
}
