package recursion;

public class isSorted {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(checkSorted(arr, 0, arr.length - 1));

    }

    private static boolean checkSorted(int[] arr, int i, int size) {
        if (i == size) return true;
        if (arr[i] > arr[i + 1]) return false;
        return checkSorted(arr, i + 1, size);
    }
}


