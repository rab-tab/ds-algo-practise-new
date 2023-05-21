package heaps;

import trees.Node;

import static trees.NodesSum.solve;

public class insertion {
    static int size;
    static int arr[] = new int[10];

    public static void main(String[] args) {
        arr[0] = -1;
        arr[1] = 100;
        arr[2] = 50;
        arr[3] = 60;
        arr[4] = 40;
        arr[5] = 45;

       /* trees.Node root = new trees.Node(1);
        root.left = new trees.Node(3);
        root.right = new trees.Node(2);
        root.right.right = new trees.Node(4);
        root.right.left = new Node(5);*/
        int elem = 101;
        insert(elem, 6);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=0) System.out.println(arr[i]);
        }
    }

    public static void insert(int elem, int size) {
        size = size + 1;
        int idx = size;
        //insert elem at the end
        arr[idx] = elem;

        //now insert at the correct position
        while (idx > 1) {
            int parentIdx = idx / 2;
            if (arr[idx] > arr[parentIdx]) {
                swap(arr[idx], arr[parentIdx], idx, parentIdx);
                idx = parentIdx;
            } else {
                break;
            }
        }

    }

    private static void swap(int elem1, int elem2, int childIdx, int parentIdx) {
        arr[childIdx] = elem2;
        arr[parentIdx] = elem1;

    }


}
