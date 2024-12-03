package com.quest.InterviewQ.InterviewDay20.CollectionsTest;

import java.util.*;

public class ListToMap
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements do you want to insert : ");   //accepting no of elements in list
        int n = sc.nextInt();
        System.out.println("Enter List : ");              //accepting list elements
        for (int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }
        listToMap(list);
    }

    public static void listToMap(ArrayList<Integer> list)
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();  //final result freq->list map
        HashMap<Integer,Integer> frequencyMap=new HashMap<>(); //element->freq map

        for(int i:list)  //forming element->freq map
        {
            frequencyMap.put(i,frequencyMap.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet())   //for every entry in frequencyMap
        {
//            map.put(entry.getValue(),new ArrayList<>());  //overrides existing entry
            map.putIfAbsent(entry.getValue(),new ArrayList<>());     //put the frequency(value of frequencyMap) into key of result map  put (key,value into result map)
            map.get(entry.getValue()).add(entry.getKey()); //updating list by adding the key of frequencyMap into the ArrayList (value of result map)
        }

        System.out.println("\nFREQUENCY | LIST OF ELEMENTS");  //displaying result map
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet())
        {
            System.out.println(entry.getKey()+"         | "+entry.getValue());
        }
    }
}
