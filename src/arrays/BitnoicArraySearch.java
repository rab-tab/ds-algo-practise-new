package arrays;

public class BitnoicArraySearch {
    public static void main(String[] args) {
        int elem = 3;
        int arr[] = {1, 3, 8, 12, 4, 2};
        int index = peakElem(arr);
        System.out.println("Bitonic elem index is-- " + index + "Bitonic elem is " + arr[index]);
        int leftIndex = binarySearch(arr, 0, index - 1, elem);
        int rightIndex = binarySearch(arr, index + 1, arr.length, elem);

    }


    public static int binarySearch(int[] arr, int low, int high, int elem) {
        int mid = (low + high) / 2;
        while (low <= high) {
            if (arr[mid] == elem) return mid;
            else if (arr[mid] > elem) high = mid - 1;
            else low = mid + 1;
        }
        return mid;

    }

    public static int peakElem(int arr[]) {
        int low = 0;
        int high = arr.length;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (mid - 1 >= low && mid + 1 < high) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
            }
            if (arr[mid] < arr[mid + 1]) low = mid + 2;
            if (arr[mid] < arr[mid - 1]) high = mid - 2;
        }
        return mid;
    }


}
