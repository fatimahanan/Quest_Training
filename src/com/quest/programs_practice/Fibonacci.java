package com.quest.programs_practice;

public class Fibonacci
{
    public static void main(String[] args)
    {
        int n=10;
        int first=0;
        int second=1;
        for(int i=0;i<10;i++)
        {
            int third=first+second;
            System.out.print(first+" ");
            first=second;
            second=third;
        }
    }
}