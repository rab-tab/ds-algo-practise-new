package heaps;

//DE SHAW
public class heapify {
    static int arr[] = {-1, 12, 14, 13, 17, 15};

    public static void main(String[] args) {

        buildHeap(arr, arr.length);
    }

    public static void buildHeap(int arr[], int n) {
        for (int i = n / 2; i > 0; i--) {
            solve(arr, n, i);
        }
    }

    public static void solve(int arr[], int len, int i) {
        int index = i;
        int leftIndex = 2 * i;
        int rightIndex = 2 * i + 1;
        int largest = index;

        if (leftIndex < len && arr[largest] < arr[leftIndex]) {
            largest = leftIndex;
        }
        if (rightIndex < len && arr[largest] < arr[rightIndex]) {
            largest = rightIndex;
        }

        if (index != largest) {
            swap(arr[largest], arr[index], largest, index);
            index = largest;
            solve(arr, len, index);
        }

    }


    private static void swap(int elem1, int elem2, int childIdx, int parentIdx) {
        arr[childIdx] = elem2;
        arr[parentIdx] = elem1;

    }

}
