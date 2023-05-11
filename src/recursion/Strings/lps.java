package recursion.Strings;

public class lps {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("amomb");
        //bmoma amomb
        System.out.println("LPS is " +solve(sb1, sb1.reverse(), sb1.length()-1, sb1.length()-1));
    }

    private static int solve(StringBuffer sb1, StringBuffer sb2, int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (sb1.charAt(i) == sb2.charAt(j))
            return 1+ solve(sb1, sb2, i - 1, j - 1);
        else
            return Math.max(solve(sb1, sb2, i - 1, j), solve(sb1, sb2, i, j));

    }
}
