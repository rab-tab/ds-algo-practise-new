package stack.histogram;

import arrays.mergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.Stack;

public class maximumAreaHistogram {

    public static ArrayList<Pair> pair = new ArrayList<>();

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        int arr[] = {6, 2, 5, 4, 5, 1, 6};
        //find nsl index
        //find nsr index
        // width array=nsr index -nsl index
        // area= width array * arr elem
        // return max area
        for (int i = 0; i < arr.length; i++) {
            pair.add(new Pair(arr[i], i));
        }
        // {6,0}, {2,1} , {5,2} , {4,3} , {5,4} ,{1,5} ,{6,6}
        // 6 , 2 , 5
        int[] nsl = nsl(arr);
        int[] nsr = nsr(arr);
        int[] widthArr = new int[arr.length];
        int[] maxArea = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            widthArr[i] = nsr[i] - nsl[i] - 1;
        }
        System.out.println("Width ara is -----");
        for (Integer i : widthArr) {
            System.out.println(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxArea[i] = arr[i] * widthArr[i];
            if (maxArea[i] > max) {
                max = maxArea[i];
            }
        }
        System.out.println("max area is " + max);

    }
    //{6, 2, 5, 4, 5, 1, 6}
    public static int[] nsl(int arr[]) {
        Stack<Pair> s = new Stack<>();
        int[] nslIndex = new int[arr.length];
        int[] nslElem = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                nslIndex[i] = -1;
                nslElem[i] = -1;
            }
            if (!s.isEmpty() && s.peek().first < arr[i]) {
                nslIndex[i] = pair.get(i).second; // arr[i] - pair.first
                nslElem[i] = s.peek().first;
            }

            if (!s.isEmpty() && s.peek().first > arr[i]) {
                while (!s.isEmpty() && s.peek().first > arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    nslIndex[i] = -1;
                    nslElem[i] = -1;
                } else {
                    nslIndex[i] = pair.get(i).second;
                    nslElem[i] = s.peek().first;
                }
            }
            s.push(new Pair(arr[i], nslIndex[i]));

        }

        System.out.println("nsl indexes are-----");
        for (Integer i : nslIndex) {
            System.out.println(i);
        }
        System.out.println("nsl Elementsa are-----");
        for (Integer i : nslElem) {
            System.out.println(i);
        }

        return nslIndex;

    }

    //{6, 2, 5, 4, 5, 1, 6}
    public static int[] nsr(int arr[]) {
        Stack<Pair> s = new Stack<>();
        int[] nsrIndex = new int[arr.length];
        int[] nsrElem = new int[arr.length];
        int currIndex = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("For loop --" + i);
            if (s.isEmpty()) {
                System.out.println("stack empty initial condition");
                nsrIndex[i] = arr.length;
                nsrElem[currIndex] = arr.length;
            }
            if (!s.isEmpty() && s.peek().first <= arr[i]) {
                System.out.println("stack top " + s.peek().first + "<= " + arr[i]);
                System.out.println("stack not empty first condition, nsr elem is " + s.peek().second);
                nsrIndex[i] = pair.get(i).second;
                nsrElem[currIndex] = s.peek().first;
            } else if (!s.isEmpty() && s.peek().first >= arr[i]) {
                System.out.println("stack top " + s.peek().first + ">= " + arr[i]);
                while (!s.isEmpty() && s.peek().first >= arr[i]) {
                    System.out.println("in while ,popping---");
                    s.pop();
                }
                if (s.isEmpty()) {
                    System.out.println("stack empty second condition");
                    nsrIndex[i] = arr.length;
                    nsrElem[currIndex] = arr.length;
                } else {
                    System.out.println("stack top " + s.peek().first + "<= " + arr[i]);
                    System.out.println("stack not empty second confition , nsr elem is " + s.peek().second);
                    nsrIndex[i] = pair.get(i).second;
                    nsrElem[currIndex] = s.peek().first;
                }
            }
            System.out.println("Pushing " + arr[i] + " to stack ");
            s.push(new Pair(arr[i], nsrIndex[i]));
            currIndex++;


        }

        System.out.println("nsr indexes are-----");
        for (Integer k : nsrIndex) {
            System.out.println(k);
        }
        System.out.println("nsr Elements are-----");
        for (Integer k : nsrElem) {
            System.out.println(k);
        }
        return nsrIndex;

    }
}

