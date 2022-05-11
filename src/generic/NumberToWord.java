package generic;

public class NumberToWord {
    public static String[] units, tens, hundreds;

    public static void main(String[] args) {
        int num = 189;
        units = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        tens = new String[]{"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seven", "eighty", "ninety"};
        hundreds = new String[]{"one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred",
                "eight hundred", "nine hundred"};
        System.out.println(convertNumToWord(num));


    }


    public static String convertNumToWord(int num) {
        //units - num%10
        StringBuilder sb = new StringBuilder();
        sb.append(hundreds[(num % 1000) / 100]).append(" and ").append(tens[(num % 100) / 10]).append(units[num % 10]);
        return sb.toString();
    }
}
