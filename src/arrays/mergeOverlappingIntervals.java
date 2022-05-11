package arrays;

import java.util.ArrayList;
import java.util.Stack;

public class mergeOverlappingIntervals {
    public static void main(String[] args) {

        //https://www.educative.io/m/merge-overlapping-intervals
        ArrayList<Pair> result = new ArrayList<Pair>();
        //expected output
        // {1,8}
        result.add(new Pair(1, 5));
        result.add(new Pair(3, 7));
        result.add(new Pair(4, 6));
        result.add(new Pair(6, 8));
        System.out.println("Result 1---------");
        mergeOverlappingINtervals(result);

        //second input
        ArrayList<Pair> result1 = new ArrayList<Pair>();
        result1.add(new Pair(10, 12));
        result1.add(new Pair(12, 15));
        System.out.println("Result 2---------");
        mergeOverlappingINtervals(result1);


    }


    public static void mergeOverlappingINtervals(ArrayList<Pair> result) {
        Stack<Pair> s = new Stack<Pair>();
        s.push(result.get(0));
        //add 1,5 to stack
        for (int i = 1; i < result.size(); i++) {
            //compare with (3,7)
            //case 1 - no overlapping interval
            if (s.peek().second < result.get(i).first) {
                s.push(result.get(i));
            }

            //case 2 - overlapping interval ,
            if (s.peek().second < result.get(i).second) {
                s.peek().second = result.get(i).second;
            }

        }

        System.out.println("Merged interval is " + " { " + s.peek().first + "," + s.peek().second + "}");

    }


    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
