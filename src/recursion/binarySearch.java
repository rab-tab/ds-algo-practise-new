package recursion;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 60, 70, 90, 99};
        int target = 60;
        int pos = binarySearch(arr, target, 0, arr.length);
        if (pos == -1) {
            System.out.println(target + " not found in array ");
        } else {
            System.out.println(target + " found at " + pos + "th position ");
        }
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == key) return mid;
        if (arr[mid] < key)
            return binarySearch(arr, key, low + 1, high);
        else
            return binarySearch(arr, key, low, high - 1);
    }
}
