package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class firstNegativeNumber {
    static List<Integer> negativeNums=new ArrayList<>();
    public static void main(String[] args) {

        int arr[]={12,-1,-7,8,-15,30,13,28};
        int k=3;
        firstNegativeNumber(arr,k,0,0);
    }

    public static void firstNegativeNumber(int[] arr,int k,int i ,int j)
    {
        while(j<arr.length)
        {
            if(arr[j]<0)
            {
                negativeNums.add(arr[j]);
            }
            if(j-i+1<k)
            {j++;}
            else if(j-i+1==k)
            {
                if(negativeNums.size()==0)
                    System.out.println(0);
                else {
                    System.out.println(negativeNums.get(0));
                    if (arr[i] == negativeNums.get(0)) {
                        negativeNums.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
    }
}

