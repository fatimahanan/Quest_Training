package com.quest.InterviewQ.InterviewDay20.CollectionsTest;

import java.util.ArrayList;
import java.util.Scanner;

public class splitList
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the list  :");
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Enter the elements of the list : ");
        for(int i=0;i<n;i++)
        {
            list.add(sc.nextInt());
        }
        System.out.println("Enter partition size : ");
        int p=sc.nextInt();
        System.out.println("Partitioned list : ");
        ArrayList<ArrayList<Integer>> splitList=partitionList(list,p);
        System.out.println(splitList);

    }

    public static ArrayList<ArrayList<Integer>> partitionList(ArrayList<Integer> list, int p)
    {
        ArrayList<ArrayList<Integer>> splitList=new ArrayList<>();
        ArrayList<Integer> tempSubList=new ArrayList<>();
        for (Integer integer : list)
        {
            tempSubList.add(integer);
            if (tempSubList.size() == p)
            {
                splitList.add(new ArrayList<>(tempSubList));
                tempSubList.clear();
            }
        }
        if(!tempSubList.isEmpty())
        {
            splitList.add(new ArrayList<>(tempSubList));
        }
        return splitList;
    }
}
