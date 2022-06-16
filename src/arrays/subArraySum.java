package arrays;

public class subArraySum {
    public static void main(String[] args) {
        int n=5;
        int sum=12;
        int[] arr={1,2,3,7,5};
        subArraySum(arr,n,sum);

    }

    public static void subArraySum(int[] arr,int n , int sum)
    {
        int curr_sum=0;
        for(int i=0;i<n;i++)
        {
            curr_sum=curr_sum+arr[i];
            if(curr_sum<sum) continue;
            else if(curr_sum==sum){
                System.out.println("Index from 0 to "+i);
            }
            else if(curr_sum>sum)
            {
                int k=0;
                while(curr_sum>sum)
                {
                    curr_sum=curr_sum-arr[k];
                    k++;
                    if(curr_sum==sum) {
                        System.out.println("Index from "+ k + " to "+i);
                        break;
                    }
                }
            }

        }

    }
}
