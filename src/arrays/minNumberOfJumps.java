package arrays;

public class minNumberOfJumps {
    public static void main(String[] args) {
        int n = 11;
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        // int arr[]={1, 4, 3, 2, 6, 7};
        System.out.println("Total no of jumps " + noOfJumps(arr, n));
    }

    public static int noOfJumps(int arr[], int len) {
        int nextIndex = 0, noOfJumps = 0;
        for (int i = 0; i < len; i++) {
            System.out.println("for loop ---------");

            if (arr[nextIndex] +arr[i]> len) {
                System.out.println(arr[i] + " is greater than len - 11");
                nextIndex = len - i;
            }

            else {
                   nextIndex = nextIndex + arr[i];
                   System.out.println("Next index is "+nextIndex);
            }
            // 3->5->9  - 2 jumps ||  3->8->9 || 3->5->8->9 3 jumps || 3->9  1 jump
            noOfJumps++;
            System.out.println("No of jumps "+noOfJumps);

        }
        return noOfJumps;
    }
}
