package arrays;

public class peakElement {
    public static void main(String[] args) {
        int n=3;
        int arr[]={5,10,20,15};
        int index=peakElem(arr);
        System.out.println("Peak elem index is-- "+index + "peak elem is "+arr[index]);

    }

    public static int peakElem(int arr[])
    {
        int low=0;int high=arr.length;
        int mid=(low+high)/2;
        while(low<=high) {
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
