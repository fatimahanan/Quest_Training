package com.quest.programs_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Iterations
{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==0 && arr[i]%3==0)
            {
                System.out.println("div by both");
                break;
            }
            else if(arr[i]%2==0)
                System.out.println("div by 2");
            else if(arr[i]%3==0)
                System.out.println("div by 3");
            else
                System.out.println("not div by 2/3");
        }

        String str1="popl";
        String str2="lppo";
        if(str1.length()!=str2.length())
        {
            System.out.println("not an anagram, length not equal");
        }
        else
        {
            char[] s1=str1.toCharArray();
            char[] s2=str2.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            if(Arrays.equals(s1, s2))
                System.out.println("anagram");
            else
                System.out.println("not an anagram");
        }

        String s="harry styles harry";
        String rev="";
        for(int i=s.length()-1;i>=0;i--)
        {
            rev=rev+s.charAt(i);
        }
        System.out.println(rev);
        String[] words=s.split(" ");
        System.out.println(words.length);
        HashMap<String,Integer> wordCountMap=new HashMap<>();
        for(String word: words)
        {
            wordCountMap.put(word,wordCountMap.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry:wordCountMap.entrySet())
        {
            System.out.println(entry.getKey()+ " : "+entry.getValue());
        }


    }
}
