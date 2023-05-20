package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class longestSubstringKUniqueChars {
    static Map<Character,Integer> occurMap=new HashMap<>();
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        String s="aabacbebebe";
        int k=3;
        longestSubstring(s,k,0,0);

    }


    public static void longestSubstring(String s,int k,int i,int j)
    {
        while(j<s.length())
        {
            char ch=s.charAt(j);
            if(!occurMap.containsKey(ch)) occurMap.put(ch,1);
            else occurMap.put(ch,occurMap.get(ch)+1);

            if(occurMap.size()<k)
            {
                j++;
            }
            else if(occurMap.size()==k)
            {
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(occurMap.size()>k)
            {
                while(occurMap.size()>k) {

                    occurMap.put(ch,occurMap.get(ch)-1);
                    if(occurMap.get(ch)==0)
                    {
                        occurMap.remove(ch);
                    }
                    i++;
                }
                j++;

            }
        }
        System.out.println("max is "+max);
    }
}
