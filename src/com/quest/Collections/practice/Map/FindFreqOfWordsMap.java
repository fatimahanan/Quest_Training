package com.quest.Collections.practice.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindFreqOfWordsMap
{
    public static void main(String[] args)
    {
        HashMap<String,Integer> hm=new HashMap();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str=sc.nextLine();
//        String str="java is simple java is fun too";
        for(String word:str.toLowerCase().split(" "))
        {
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry : hm.entrySet())
        {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }

    }
}
