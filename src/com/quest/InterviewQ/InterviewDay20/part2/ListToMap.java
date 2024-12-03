package com.quest.InterviewQ.InterviewDay20.part2;

import java.util.*;

public class ListToMap
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements do you want to insert : ");
        int n = sc.nextInt();
        System.out.println("Enter List : ");
        for(int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        HashMap<Integer,Integer> frequencyMap=new HashMap<>();
        for(int i:list)
        {
            frequencyMap.put(i,frequencyMap.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet())
        {
//            map.putIfAbsent(entry.getValue(),new ArrayList<>());  //overrides existing entry
            map.putIfAbsent(entry.getValue(),new ArrayList<>());
            map.get(entry.getValue()).add(entry.getKey()); //updating list by adding the key
        }

        System.out.println("\nFREQUENCY | LIST OF ELEMENTS");
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet())
        {
            System.out.println(entry.getKey()+"         | "+entry.getValue());
        }
    }
}
