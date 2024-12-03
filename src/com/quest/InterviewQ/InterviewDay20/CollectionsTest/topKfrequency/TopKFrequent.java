package com.quest.InterviewQ.InterviewDay20.CollectionsTest.topKfrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TopKFrequent
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("Enter the list : ");
        for(int i=0;i<n;i++)
        {
            list.add(sc.nextLine());
        }
        System.out.println("Enter k  : ");
        int k=sc.nextInt();
        ArrayList<String> result=findTopKFrequent(list,k);
        System.out.println(result);
    }

    public static ArrayList<String> findTopKFrequent(ArrayList<String> list, int k)
    {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:list)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }

        //put hashmap into list to sort
        ArrayList<Map.Entry<String,Integer>> sortedList=new ArrayList<>(map.entrySet());
        sortedList.sort(new SortByFreqComparator());

        ArrayList<String> topKString=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            topKString.add(sortedList.get(i).getKey());
        }
        return topKString;
    }


}
