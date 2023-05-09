package recursion.Strings.subsequences.reverseString;

public class reverseString {
    public static void main(String[] args) {
        String str = "performance";
        reverse(str, str.length(), "");
    }

    private static void reverse(String str, int idx, String revStr) {

        if (idx == 0) {
            System.out.println(revStr);
            return ;
        }
         reverse(str, idx -1, revStr+str.charAt(idx-1));
    }
}
