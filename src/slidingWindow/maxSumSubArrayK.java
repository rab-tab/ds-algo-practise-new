package slidingWindow;

public class maxSumSubArrayK {
    public static int k=3;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        int arr[]={4,1,1,1,2,3,5};
        int sum=0;
        System.out.println("Max len is "+ maxSumSubArray(arr,sum,arr.length));
    }

    public static int maxSumSubArray(int[] arr,int sum,int n)
    {
        int i=0;int j=0;
        int maxLen=Integer.MIN_VALUE;
        while(j<arr.length)
        {
            sum=sum+arr[i];
            if(j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            {
                max=Math.max(sum,max);
                sum=sum-arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
