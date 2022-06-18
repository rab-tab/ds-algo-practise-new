package backtracking;

public class maxNoKSwaps {
    static String max=String.valueOf(Integer.MIN_VALUE);
    static String swappedStr;

    public static void main(String[] args) {
        String str = "1234567";
        int k = 4;
        findMaximum(str,k);
        System.out.println("Max is---"+max);

    }

    public static void findMaximum(String str, int k) {
        if (Integer.parseInt(str) > Integer.parseInt(max))
            max = str;
        if (k == 0) return;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    swappedStr = swap(str, i, j);
                    findMaximum(str, k - 1);
                    swappedStr = swap(str, i, j); // backtracking
                }
            }

        }
    }

    public static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        String left = str.substring(0, i);
        String mid = str.substring(i + 1, j);
        String right = str.substring(j + 1);
        return left + jth + mid + ith + right;
    }
}
