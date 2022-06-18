package recursion;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=hMJAlbJIS7E&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=30
public class stairsPath {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> paths = stairsPath(n);
        for (String s : paths) {
            System.out.println(s);
        }

    }

    public static ArrayList<String> stairsPath(int n) {

        if (n == 0) {
            ArrayList<String> tempRes = new ArrayList<>();
            tempRes.add("");
            return tempRes;
        } else if (n < 0) {
            ArrayList<String> tempRes = new ArrayList<>();
            return tempRes;

        }

        ArrayList<String> paths1 = stairsPath(n - 1);
        ArrayList<String> paths2 = stairsPath(n - 2);
        ArrayList<String> paths3 = stairsPath(n - 3);
        ArrayList<String> paths = new ArrayList<>();

        for (String path : paths1) {
            paths.add(1 + path);
        }
        for (String path : paths2) {
            paths.add(2 + path);
        }
        for (String path : paths3) {
            paths.add(3 + path);
        }
        return paths;

    }

}
