package slidingWindow;

import java.util.HashMap;

public class countAnagrams {
    public static void main(String[] args) {
        String s1="forxxorfxdofr";
        String s2="for";
        countOccur(s1,s2);
    }

    public static void countOccur(String s1,String s2)
    {
        int i=0;int j=0;
        int anagramCount=0;
        int windowLen=s2.length();
        HashMap<Character,Integer> occurMap=new HashMap<>();
        for(Character c:s2.toCharArray())
        {
            if(occurMap.containsKey(c)) {
                int temp=occurMap.get(c);
                occurMap.put(c, temp++);
            }
            else occurMap.put(c,1);
        }
        int count=occurMap.size();
        while(j<s1.length())
        {
            if(occurMap.containsKey(s1.charAt(j)))
            {
                System.out.println("conut is "+count);
                occurMap.put(s1.charAt(j),occurMap.get(s1.charAt(j))-1);
                if(occurMap.get(s1.charAt(j))==0){
                    count--;
                }
            }
            if(j-i+1<windowLen)
            {
                j++;
            }
            else if(j-i+1==windowLen)
            {
                if(count==0) {
                    System.out.println("Count is 0");
                    anagramCount++;
                }
                if(!occurMap.containsKey(s1.charAt(i))) {
                    occurMap.put(s1.charAt(j),1);
                    count++;
                }
                i++;
                j++;
            }

        }
        System.out.println("Anagram count is "+anagramCount);
    }
}

