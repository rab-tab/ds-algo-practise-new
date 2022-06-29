package trees;

public class PalindromePartioning {
    public static void main(String[] args) {
        String s = "malayalam";
        palindromePartition(s, "");
    }


    public static void palindromePartition(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);
            if (isPalindrome(left)) {
                palindromePartition(right, ans + "(" + left + ")");

            }
        }
    }

    public static boolean isPalindrome(String str) {
        int leftIndex = 0;
        int rightIndex = str.length()-1;
        while (leftIndex < rightIndex) {
            char left = str.charAt(leftIndex);
            char right = str.charAt(rightIndex);
            if (left != right) return false;
            leftIndex++;
            rightIndex--;
        }
        return true;

    }
}
