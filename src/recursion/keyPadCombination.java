package recursion;

import java.util.ArrayList;

public class keyPadCombination {
    public static void main(String[] args) {
        String str = "678";
        String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

        ArrayList<String> result = keyPadCombination(str, codes);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("Total combinatiosn "+result.size());

    }


    public static ArrayList<String> keyPadCombination(String str, String[] codes) {
        if (str.length() == 0) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add("");
            return tempList;
        }
        char ch = str.charAt(0); //5
        String tempStr = str.substring(1);// 73

        ArrayList<String> tempRes = keyPadCombination(tempStr, codes);
        ArrayList<String> res = new ArrayList<>();

        String tempCode = codes[ch -'0'];
        for (int i = 0; i < tempCode.length(); i++) {
            char chCode = tempCode.charAt(i);
            for (String s1 : tempRes) {
                res.add(chCode + s1);
            }
        }

        return res;
    }
}
