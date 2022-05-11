package stack;

public class stockSpan {
    public static void main(String[] args) {

        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        // 100 : 1
        // 80 :1
        //60  : 1
        //70 :2
        stockSpanProb(arr);

    }

    public static void stockSpanProb(int[] arr) {
        int[] ngrIndex = new int[arr.length];
        ngrIndex[0] = 1;
        int tempCount;
        for (int i = 1; i < arr.length; i++) {
            tempCount = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) tempCount++;

            }
            ngrIndex[i] = tempCount;
        }
        System.out.println("Stock span count -----");
        for(int i=0;i<ngrIndex.length;i++)
        {
            System.out.println(arr[i] + "-----" + ngrIndex[i]);
        }
    }


}
