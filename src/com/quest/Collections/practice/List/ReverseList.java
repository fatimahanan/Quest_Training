package com.quest.Collections.practice.List;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseList
{
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3, 2, 1, 8, 7, 4));
        System.out.println("original list : "+al);
        int start = 0;
        int end = al.size() - 1;
        while (start <= end)
        {
            int temp = al.get(start);
            al.set(start, al.get(end));
            al.set(end, temp);
            end--;
            start++;
        }
        System.out.println("reversed list : "+al);
    }
}
