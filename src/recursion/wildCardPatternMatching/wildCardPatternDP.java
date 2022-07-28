package recursion.wildCardPatternMatching;

public class wildCardPatternDP {
    public static void main(String[] args) {
            String s = "summer";
            String pattern = "s*e?";
            isMatch(s, pattern, s.length(), pattern.length(), 0, 0);
            //? - any one character
            //* -0 or more  chars
            isMatch(s, pattern, s.length(), pattern.length(), 0, 0);
            System.out.println(isMatch(s, pattern, s.length(), pattern.length(), 0, 0));
        }

        private static boolean isMatch(String s, String pattern, int strLen, int patternLen,
        int strIndex, int patternIndex) {
            if (strIndex == strLen && patternIndex == patternLen)
                return true;
            if (patternIndex == patternLen) return false;
            if (strIndex == strLen && patternIndex != patternLen) {
                for (int i = patternIndex; i < patternLen; i++) {
                    if (pattern.charAt(i) != '*') return false;
                }
                return true;
            }

            if (s.charAt(strIndex) != pattern.charAt(patternIndex)) return false;

            if (s.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '?') {
                return isMatch(s, pattern, strLen, patternLen, strIndex + 1, patternIndex + 1);
            }
            if (pattern.charAt(patternIndex) == '*') {
                return (isMatch(s, pattern, strLen, patternLen, strIndex + 1, patternIndex) ||
                        isMatch(s, pattern, strLen, patternLen, strIndex, patternIndex + 1));
            }
            return false;

        }


}
