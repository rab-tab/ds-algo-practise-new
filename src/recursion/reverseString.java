package recursion;

public class reverseString {
    public static void main(String[] args) {
        String s = "abcd";
        reverse(s, s.length(), "");
    }


    public static void reverse(String s, int len, String rev) {
        if (len == 0) {
            System.out.println(rev);
            return;
        }
        reverse(s, len - 1, rev + s.charAt(len-1));

    }
}
