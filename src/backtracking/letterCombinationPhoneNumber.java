package backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationPhoneNumber {
    public static void main(String[] args) {
        char arr[][] = {{'a', 'b', 'c'}, //2
                {'d', 'e', 'f'}, //3
                {'g', 'h', 'i'}, //4
                {'j', 'k', 'l'}, //5
                {'m', 'n', 'o'}, //6
                {'p', 'q', 'q', 's'}, //7
                {'t', 'u', 'v'}, //8
                {'w', 'x', 'y', 'z'}};//9
        String s = "23";
        solve(arr, s);

    }

    private static void solve(char[][] arr, String s) {
        List<String> ans = new ArrayList<>();
        //get char row for s[i]
        char ch = s.charAt(0); //2
        //find out row no;
        int rowNo = ch - '0'; //2
        rowNo = rowNo - 2;
        //combine with all other numbers in s
        for (int i = 1; i < s.length(); i++) {
            //get char row for s[i]
            char ch1 = s.charAt(i); //3
            //find out row no;
            int rowNo1 = ch1 - '0'; //3
            rowNo1 = rowNo1 - 2;
            
            for (int col = 0; col < arr[rowNo].length; col++) {
                for (int col1 = 0; col1 < arr[rowNo1].length; col1++) {
                    System.out.println("char 1 .. " + arr[rowNo][col]);
                    System.out.println("char 2 ... " + arr[rowNo1][col1]);
                    String temp = Character.toString(arr[rowNo][col]) + Character.toString(arr[rowNo1][col1]);
                    System.out.println("temp is " + temp);
                    ans.add(temp);
                }

            }
        }

        System.out.println("Combinations are ");
        for (String str : ans) {
            System.out.println(str);
        }
    }


}
