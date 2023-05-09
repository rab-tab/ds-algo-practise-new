package recursion.Strings.subsequences.reverseString;

public class reverseStringApproach2 {
    public static String rev = "";

    public static void main(String[] args) {
        String str = "abc";
        reverse(str, 0);
        System.out.println("rev is " + rev);
    }

    private static void reverse(String str, int idx) {
        if (idx == str.length()) {
            System.out.println(rev);
            return;
        }
        reverse(str, idx + 1);
        //process after return
        rev = rev + str.charAt(idx);

    }
}
