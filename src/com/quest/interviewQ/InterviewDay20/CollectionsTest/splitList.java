package com.quest.interviewQ.InterviewDay20.CollectionsTest;

import java.util.ArrayList;
import java.util.Scanner;

public class splitList
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the list  :");          //accepting list size
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Enter the elements of the list : ");     //accepting list elements
        for(int i=0;i<n;i++)
        {
            list.add(sc.nextInt());
        }
        System.out.println("Enter partition size : ");               //accepting partition size
        int p=sc.nextInt();
        System.out.println("Partitioned list : ");
        ArrayList<ArrayList<Integer>> splitList=partitionList(list,p);   //calling partition function (below)
        System.out.println(splitList);

    }

    public static ArrayList<ArrayList<Integer>> partitionList(ArrayList<Integer> list, int p)
    {
        ArrayList<ArrayList<Integer>> splitList=new ArrayList<>(); //final result list
        ArrayList<Integer> tempSubList=new ArrayList<>(); //for each list
        for (Integer integer : list)
        {
            tempSubList.add(integer);             //add integer to templist
            if (tempSubList.size() == p)          //check if size has reached partition size
            {
                splitList.add(new ArrayList<>(tempSubList));     //if yes, then add the sublist to the result list
                tempSubList.clear();
            }
        }
        if(!tempSubList.isEmpty())              //if there are remaining elements that is less than partition size in the end
        {
            splitList.add(new ArrayList<>(tempSubList));
        }
        return splitList;
    }
}
