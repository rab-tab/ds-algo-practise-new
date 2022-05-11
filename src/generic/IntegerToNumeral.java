package generic;

import java.util.HashMap;

public class IntegerToNumeral {
    public static void main(String[] args) {
        int num = 898;
        //I -1
        // V-5
        //X -10
        // L- 50
        // C- 100
        // D- 500
        //M - 1000
      //  System.out.println(intToRoman(num));
        int temp=898%100;
        System.out.println(temp);
        System.out.println(temp/10);

    }

    public static String intToRoman(int num) {
        // 1 2 3 4 5 6 7 8 9
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 10 20 30 40 50 60 70 80 90
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //100 200 300 400 500 600 700 800 900
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //1000 //2000 //3000
        String[] thousands = {"", "M", "MM", "MMM"};
        // units position 898 - 898% 10 - 8
        //tens position   - 898%100 -
        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
    }
}
