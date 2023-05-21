package heaps;

public class deletion {
    static int size;
    static int arr[] = new int[8];

    //we can delete only root node
    //steps:    1) replace root node with last elem 2) place root elem in its right position
    public static void main(String[] args) {
        arr[0] = -1;
        arr[1] = 100;
        arr[2] = 50;
        arr[3] = 60;
        arr[4] = 40;
        arr[5] = 45;
        arr[6] = 53;
        arr[7] = 52;
        delete(arr[7], arr.length);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void delete(int elem, int len) {
        //   1) replace root node with last elem
        arr[1] = elem;
        len = len - 1;
        int currIdx = 1;
        while (currIdx < len) {
            int leftIdx = currIdx * 2;
            int rightIdx = currIdx * 2 + 1;
            int largest = currIdx;

            if (leftIdx < len && arr[largest] < arr[leftIdx]) {
                largest = leftIdx;
            }
            if (rightIdx < len && arr[largest] < arr[rightIdx]) {
                largest = rightIdx;
            }
            if (largest == currIdx) return;

            else {
                swap(arr[largest], arr[currIdx], largest, currIdx);
                currIdx = largest;
            }
            currIdx++;
        }

    }

    private static void swap(int elem1, int elem2, int childIdx, int parentIdx) {
        arr[childIdx] = elem2;
        arr[parentIdx] = elem1;

    }
}
