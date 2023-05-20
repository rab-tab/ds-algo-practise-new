package slidingWindow;

public class maximumSumSubArray {
    public static void main(String[] args) {
        int arr[]={4,1,1,1,2,3,5};
        int sum=6;
        System.out.println("Max len is "+ maxSumSubArray(arr,sum,arr.length));
    }

    public static int maxSumSubArray(int[] arr,int sum,int n)
    {
        int i=0;int j=0;
        int maxLen=Integer.MIN_VALUE;
        int tempSum=0;
        while(j<n)
        {
            tempSum=tempSum+arr[j];
            if(tempSum<sum)
            {
                j++;
            }
            if(tempSum==sum)
            {
                maxLen=Math.max(maxLen,j-i+1);

            }
            else if(tempSum>sum)
            {
                while(tempSum>sum) {
                    tempSum = tempSum - arr[i];
                    i++;
                }
                j++;
            }

        }
        return maxLen;

    }
}
