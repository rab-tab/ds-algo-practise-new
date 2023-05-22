package binarySearch;

public class peakElement {
    public static void main(String[] args) {
        int arr[] = {5, 10, 20, 15};
        int index = findPeakElem(arr, 0, arr.length - 1);
        if (index != -1) {
            System.out.println("Peak elem is " + arr[index]);
        } else {
            System.out.println("No peak elem found");
        }
        // peak elem - greater than both the neighbours
    }

    public static int findPeakElem(int arr[], int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid > 0 && mid < high) {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                    return mid;
                else if (arr[mid] < arr[mid - 1])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            if (mid == 0) {
                if (arr[0] > arr[1]) return 0;
                else return 1;
            }
            if (mid == high) {
                if (arr[high] > arr[high - 1]) return high;
                else return high - 1;
            }
        }
        return -1;
    }
}

